package jdbc_practice.scenario_based;

import java.sql.*;
import java.util.Scanner;

public class UpdatePatientInfo {

    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/jdbclearning";
    private static final String USER = "root";
    private static final String PASSWORD = "Abhiji@2001"; 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Search patient by:");
            System.out.println("1. ID");
            System.out.println("2. Phone");
            int choice = sc.nextInt();
            sc.nextLine();

            ResultSet rs = null;
            PreparedStatement psSearch = null;

            if (choice == 1) {
                System.out.print("Enter Patient ID: ");
                int id = sc.nextInt();

                String searchById = "SELECT * FROM patient_info WHERE id = ?";
                psSearch = con.prepareStatement(searchById);
                psSearch.setInt(1, id);
                rs = psSearch.executeQuery();

            } else if (choice == 2) {
                System.out.print("Enter Phone Number: ");
                String phone = sc.nextLine();

                String searchByPhone = "SELECT * FROM patient_info WHERE phone = ?";
                psSearch = con.prepareStatement(searchByPhone);
                psSearch.setString(1, phone);
                rs = psSearch.executeQuery();
            } else {
                System.out.println("Invalid choice.");
                return;
            }

            if (rs.next()) {

                int patientId = rs.getInt("id");

                // Display current details
                System.out.println("\nCurrent Patient Details:");
                System.out.println("ID: " + patientId);
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("DOB: " + rs.getDate("dobb"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("Blood Group: " + rs.getString("blood_group"));

                sc.nextLine();

                // Take updated values
                System.out.println("\nEnter Updated Details:");

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("DOB (yyyy-mm-dd): ");
                String dobInput = sc.nextLine();
                Date dob = Date.valueOf(dobInput);

                System.out.print("Phone: ");
                String phone = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Address: ");
                String address = sc.nextLine();

                System.out.print("Blood Group: ");
                String bloodGroup = sc.nextLine();

                // UPDATE query using WHERE id
                String updateQuery = "UPDATE patient_info SET name=?, dobb=?, phone=?, email=?, address=?, blood_group=? WHERE id=?";

                PreparedStatement psUpdate = con.prepareStatement(updateQuery);

                psUpdate.setString(1, name);
                psUpdate.setDate(2, dob);
                psUpdate.setString(3, phone);
                psUpdate.setString(4, email);
                psUpdate.setString(5, address);
                psUpdate.setString(6, bloodGroup);
                psUpdate.setInt(7, patientId);

                int rowsUpdated = psUpdate.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("\nPatient information updated successfully.");
                } else {
                    System.out.println("\nUpdate failed.");
                }

                psUpdate.close();

            } else {
                System.out.println("Patient not found.");
            }

            if (rs != null) rs.close();
            if (psSearch != null) psSearch.close();

        } catch (SQLException e) {
            System.out.println("Database Error:");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date format. Use yyyy-mm-dd.");
        }

        sc.close();
    }
}

