package com.csvdata.dbtocsv;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenerateEmployeeCSV {
    public static void main(String[] args) {
	// Verify MySQL Connector/J Is Loaded
	/*
	 * try { Class.forName("com.mysql.cj.jdbc.Driver");
	 * System.out.println("MySQL Driver Loaded Successfully"); } catch
	 * (ClassNotFoundException e) {
	 * System.out.println("MySQL Driver NOT found in classpath");
	 * e.printStackTrace(); return; }
	 */

	// sample database link
	String url = "jdbc:mysql://127.0.0.1:3306/sampledb" + "?useSSL=false" + "&allowPublicKeyRetrieval=true"
		+ "&serverTimezone=UTC";

	String username = "myUsername";
	String password = "myPassword";

	// sample file path
	String filePath = "samplefiles/dbtocsv/employee_report.csv";

	try (Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id, name, department, salary FROM employees");
		FileWriter writer = new FileWriter(filePath)) {

	    // write header
	    writer.write("Employee ID,Name,Department,Salary\n");

	    while (rs.next()) {

		// write each database record
		writer.write(rs.getInt("id") + "," + rs.getString("name") + "," + rs.getString("department") + ","
			+ rs.getInt("salary") + "\n");
	    }

	    System.out.println("CSV report generated successfully");

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }
}
