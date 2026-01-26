package com.csvdata.writecsv;

import java.io.FileWriter;
import java.io.IOException;

public class WriteEmployeeCSV {
    public static void main(String[] args) {
	// sample file path
        String filePath = "samplefiles/writecsv/employees.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            // write header
            writer.write("ID,Name,Department,Salary\n");

            // write employee records
            writer.write("201,Alex,HR,45000\n");
            writer.write("202,Sophia,IT,60000\n");
            writer.write("203,Daniel,Finance,52000\n");
            writer.write("204,Olivia,IT,65000\n");
            writer.write("205,Michael,Admin,40000\n");

            System.out.println("Employee data written to CSV file successfully");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file");
        }
    }
}
