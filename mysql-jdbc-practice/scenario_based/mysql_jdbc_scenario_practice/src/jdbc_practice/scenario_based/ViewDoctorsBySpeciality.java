package jdbc_practice.scenario_based;

import java.sql.*;
import java.util.Scanner;

public class ViewDoctorsBySpeciality {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbclearning";
    private static final String USER = "root";
    private static final String PASSWORD = "Abhiji@2001";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // Show available specialties
            String specQuery = "SELECT speciality FROM specialties";

            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(specQuery)) {

                System.out.println("Available Specialties:");
                while (rs.next()) {
                    System.out.println("- " + rs.getString("speciality"));
                }
            }

            System.out.print("\nEnter Specialty Name: ");
            String specialtyName = sc.nextLine();

            String sql = """
                    SELECT 
                        d.id,
                        d.name,
                        d.contact,
                        d.consultation_fee,
                        s.speciality,
                        a.appointment_date,
                        a.appointment_time,
                        a.status
                    FROM doctors d
                    JOIN specialties s ON d.specialization = s.id
                    LEFT JOIN appointments a ON d.id = a.doctor_id
                    WHERE s.speciality = ?
                    AND d.is_active = 1
                    ORDER BY d.id, a.appointment_date, a.appointment_time
                    """;

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, specialtyName);

                try (ResultSet rs = ps.executeQuery()) {

                    boolean found = false;
                    int currentDoctor = -1;

                    while (rs.next()) {

                        found = true;

                        int doctorId = rs.getInt("id");

                        // Print doctor details once
                        if (doctorId != currentDoctor) {
                            currentDoctor = doctorId;

                            System.out.println("\n=================================");
                            System.out.println("Doctor ID : " + doctorId);
                            System.out.println("Name      : " + rs.getString("name"));
                            System.out.println("Contact   : " + rs.getString("contact"));
                            System.out.println("Fee       : " + rs.getString("consultation_fee"));
                            System.out.println("Specialty : " + rs.getString("speciality"));
                            System.out.println("---- Schedule ----");
                        }

                        Date date = rs.getDate("appointment_date");
                        Time time = rs.getTime("appointment_time");

                        if (date != null) {
                            System.out.println("Date: " + date +
                                    " | Time: " + time +
                                    " | Status: " + rs.getString("status"));
                        } else {
                            System.out.println("No appointments scheduled.");
                        }
                    }

                    if (!found) {
                        System.out.println("No doctors found for this specialty.");
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        sc.close();
    }
}

