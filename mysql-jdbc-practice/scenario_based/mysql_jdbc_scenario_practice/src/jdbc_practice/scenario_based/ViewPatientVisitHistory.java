package jdbc_practice.scenario_based;

import java.sql.*;
import java.util.Scanner;

public class ViewPatientVisitHistory {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbclearning";
    private static final String USER = "root";
    private static final String PASSWORD = "Abhiji@2001"; 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();

        String sql = """
                SELECT 
                    a.appointment_date,
                    a.appointment_time,
                    d.doctor_name,
                    v.diagnosis,
                    v.notes,
                    v.visit
                FROM appointments a
                JOIN visits v ON a.appointment_id = v.appointment_id
                JOIN doctors d ON a.doctor_id = d.doctor_id
                WHERE a.patient_id = ?
                ORDER BY a.appointment_date ASC, a.appointment_time ASC
                """;

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            try (ResultSet rs = ps.executeQuery()) {

                boolean found = false;

                System.out.println("\n===== Patient Visit History =====");

                while (rs.next()) {
                    found = true;

                    System.out.println("Visit Date     : " + rs.getDate("visit"));
                    System.out.println("Appointment    : " + rs.getDate("appointment_date")
                            + " " + rs.getTime("appointment_time"));
                    System.out.println("Doctor         : " + rs.getString("doctor_name"));
                    System.out.println("Diagnosis      : " + rs.getString("diagnosis"));
                    System.out.println("Notes          : " + rs.getString("notes"));
                    System.out.println("-------------------------------------");
                }

                if (!found) {
                    System.out.println("No visit history found for this patient.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database Error:");
            e.printStackTrace();
        }
        sc.close();
    }
}
