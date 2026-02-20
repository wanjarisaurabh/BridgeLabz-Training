package jdbc_practice.scenario_based;

import java.sql.*;
import java.util.Scanner;

public class AddDoctorProfile {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbclearning";
    private static final String USER = "root";
    private static final String PASSWORD = "Abhiji@2001";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // Step 1: Display available specializations
            String specQuery = "SELECT id, specialty_name FROM specialties";

            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(specQuery)) {

                System.out.println("Available Specializations:");
                while (rs.next()) {
                    System.out.println(
                        rs.getInt("id") + " - " + rs.getString("specialty_name")
                    );
                }
            }

            // Step 2: Input doctor details
            System.out.println("\nEnter Doctor Details:");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Contact: ");
            String contact = sc.nextLine();

            System.out.print("Consultation Fee: ");
            String fee = sc.nextLine();

            System.out.print("Specialization ID: ");
            int specializationId = sc.nextInt();

            // Step 3: Insert into doctors table
            String insertSQL = """
                    INSERT INTO doctors
                    (name, email, contact, consultation_fee, specialization, is_active)
                    VALUES (?, ?, ?, ?, ?, 1)
                    """;

            try (PreparedStatement ps = con.prepareStatement(insertSQL)) {

                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, contact);
                ps.setString(4, fee);
                ps.setInt(5, specializationId);

                int rowsInserted = ps.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("\nDoctor profile added successfully.");
                } else {
                    System.out.println("\nInsertion failed.");
                }
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: Invalid specialization ID (Foreign Key violation).");
        } catch (SQLException e) {
            System.out.println("Database Error:");
            e.printStackTrace();
        }
        sc.close();
    }
}

