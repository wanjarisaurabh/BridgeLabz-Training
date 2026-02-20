package jdbc_practice.scenario_based;

import java.sql.*;
import java.util.Scanner;

public class UpdateDoctorsSpecialty {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbclearning";
    private static final String USER = "root";
    private static final String PASSWORD = "Abhiji@2001";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // Disable auto-commit for transaction control
            con.setAutoCommit(false);

            try {

                // Step 1: Display Specialties
                String specQuery = "SELECT id, speciality FROM specialties";
                try (Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery(specQuery)) {

                    System.out.println("Available Specialties:");
                    while (rs.next()) {
                        System.out.println(
                                rs.getInt("id") + " - " +
                                rs.getString("speciality"));
                    }
                }

                // Step 2: Display Doctors
                String docQuery = "SELECT id, name FROM doctors WHERE is_active = 1";
                try (Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery(docQuery)) {

                    System.out.println("\nActive Doctors:");
                    while (rs.next()) {
                        System.out.println(
                                rs.getInt("id") + " - " +
                                rs.getString("name"));
                    }
                }

                // Step 3: Input values
                System.out.print("\nEnter Doctor ID to update: ");
                int doctorId = sc.nextInt();

                System.out.print("Enter New Specialty ID: ");
                int specialtyId = sc.nextInt();

                // Step 4: Update using PreparedStatement
                String updateSQL = """
                        UPDATE doctors
                        SET specialization = ?
                        WHERE id = ?
                        """;

                try (PreparedStatement ps = con.prepareStatement(updateSQL)) {

                    ps.setInt(1, specialtyId);
                    ps.setInt(2, doctorId);

                    int rowsUpdated = ps.executeUpdate();

                    if (rowsUpdated == 0) {
                        throw new SQLException("Doctor not found.");
                    }

                    // Commit transaction
                    con.commit();
                    System.out.println("\nDoctor specialty updated successfully.");
                }

            } catch (SQLException e) {

                // Rollback on error
                con.rollback();
                System.out.println("Transaction failed. Rolled back.");
                e.printStackTrace();
            }

            // Re-enable auto-commit
            con.setAutoCommit(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
