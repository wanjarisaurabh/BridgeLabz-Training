package jdbc_practice.scenario_based;

import java.sql.*;
import java.time.LocalDate;

public class RegisterPatient {
	 private static final String URL =
	            "jdbc:mysql://localhost:3306/patient_management";
	    private static final String USER = "root";
	    private static final String PASS = "Abhiji@2001";

	    public static void main(String[] args) {

	        registerPatient(
	                "John Doe",
	                LocalDate.of(1995, 5, 12),
	                "9876543210",
	                "john@example.com",
	                "New York",
	                "O+"
	        );
	    }

	    public static void registerPatient(String name,
	                                       LocalDate dob,
	                                       String phone,
	                                       String email,
	                                       String address,
	                                       String bloodGroup) {

	        String checkSql =
	                "SELECT id FROM patient_info WHERE phone = ? OR email = ?";

	        String insertSql =
	                "INSERT INTO patient_info(name, dobb, phone, email, address, blood_group) "
	                        + "VALUES (?, ?, ?, ?, ?, ?)";

	        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

	            // Step 1: Check uniqueness
	            try (PreparedStatement checkStmt =
	                         con.prepareStatement(checkSql)) {

	                checkStmt.setString(1, phone);
	                checkStmt.setString(2, email);

	                ResultSet rs = checkStmt.executeQuery();

	                if (rs.next()) {
	                    System.out.println("Patient already exists!");
	                    return;
	                }
	            }

	            // Step 2: Insert new patient
	            try (PreparedStatement insertStmt =
	                         con.prepareStatement(insertSql,
	                                 Statement.RETURN_GENERATED_KEYS)) {

	                insertStmt.setString(1, name);
	                insertStmt.setDate(2, Date.valueOf(dob));
	                insertStmt.setString(3, phone);
	                insertStmt.setString(4, email);
	                insertStmt.setString(5, address);
	                insertStmt.setString(6, bloodGroup);

	                int rows = insertStmt.executeUpdate();

	                if (rows > 0) {
	                    ResultSet keys = insertStmt.getGeneratedKeys();
	                    if (keys.next()) {
	                        int generatedId = keys.getInt(1);
	                        System.out.println("Patient Registered Successfully!");
	                        System.out.println("Generated Patient ID: " + generatedId);
	                    }
	                }
	            }

	        } catch (SQLException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
}
