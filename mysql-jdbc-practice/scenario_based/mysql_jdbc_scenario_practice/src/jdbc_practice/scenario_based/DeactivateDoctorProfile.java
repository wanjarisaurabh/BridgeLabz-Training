package jdbc_practice.scenario_based;

import java.sql.*;
import java.util.Scanner;

public class DeactivateDoctorProfile {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbclearning";
    private static final String USER = "root";
    private static final String PASSWORD = "Abhiji@2001";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            con.setAutoCommit(false); // Start transaction

            try {

                // Step 1: Display Active Doctors
                String doctorQuery = "SELECT id, name FROM doctors WHERE is_active = 1";

                try (Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery(doctorQuery)) {

                    System.out.println("Active Doctors:");
                    while (rs.next()) {
                        System.out.println(
                                rs.getInt("id") + " - " +
                                rs.getString("name"));
                    }
                }

                System.out.print("\nEnter Doctor ID to deactivate: ");
                int doctorId = sc.nextInt();

                // Step 2: Check Future Appointments
                String checkAppointments = """
                        SELECT COUNT(*)
                        FROM appointments
                        WHERE doctor_id = ?
                        AND appointment_date > CURDATE()
                        AND status IN ('pending', 'scheduled')
                        """;

                try (PreparedStatement psCheck = con.prepareStatement(checkAppointments)) {

                    psCheck.setInt(1, doctorId);

                    try (ResultSet rs = psCheck.executeQuery()) {

                        if (rs.next() && rs.getInt(1) > 0) {
                            System.out.println("Doctor has future appointments. Cannot deactivate.");
                            con.rollback();
                            return;
                        }
                    }
                }

                // Step 3: Soft Delete
                String deactivateSQL = """
                        UPDATE doctors
                        SET is_active = 0
                        WHERE id = ?
                        """;

                try (PreparedStatement psUpdate = con.prepareStatement(deactivateSQL)) {

                    psUpdate.setInt(1, doctorId);

                    int rows = psUpdate.executeUpdate();

                    if (rows == 0) {
                        throw new SQLException("Doctor not found.");
                    }
                }

                // Commit transaction
                con.commit();
                System.out.println("Doctor profile deactivated successfully.");

            } catch (SQLException e) {
                con.rollback();
                System.out.println("Transaction failed. Rolled back.");
                e.printStackTrace();
            }

            con.setAutoCommit(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
