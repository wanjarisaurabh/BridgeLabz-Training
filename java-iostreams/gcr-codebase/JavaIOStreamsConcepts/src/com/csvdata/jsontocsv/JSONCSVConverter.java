package com.csvdata.jsontocsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONCSVConverter {
    public static void main(String[] args) {
	convertJSONToCSV();
	convertCSVToJSON();
    }

    // convert JSON file to CSV
    public static void convertJSONToCSV() {
	// sample files paths
	String jsonFile = "samplefiles/jsontocsv/students.json";
	String csvFile = "samplefiles/jsontocsv/students_from_json.csv";

	try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
		FileWriter writer = new FileWriter(csvFile)) {

	    // write CSV header
	    writer.write("ID,Name,Age,Marks\n");

	    String line;
	    while ((line = reader.readLine()) != null) {
		// remove symbols and split manually
		line = line.replace("{", "").replace("}", "").replace("\"", "");

		String[] arr = line.split(",");

		String id = arr[0].split(":")[1];
		String name = arr[1].split(":")[1];
		String age = arr[2].split(":")[1];
		String marks = arr[3].split(":")[1];

		writer.write(id + "," + name + "," + age + "," + marks + "\n");
	    }

	    System.out.println("JSON to CSV conversion completed");

	} catch (IOException e) {
	    System.out.println("Error converting JSON to CSV");
	}
    }

    // convert CSV file to JSON
    public static void convertCSVToJSON() {
	// sample files paths
	String csvFile = "samplefiles/jsontocsv/students.csv";
	String jsonFile = "samplefiles/jsontocsv/students_from_csv.json";

	try (BufferedReader reader = new BufferedReader(new FileReader(csvFile));
		FileWriter writer = new FileWriter(jsonFile)) {

	    String line;
	    boolean isHeader = true;
	    while ((line = reader.readLine()) != null) {
		// skip header
		if (isHeader) {
		    isHeader = false;
		    continue;
		}

		String[] arr = line.split(",");

		// write JSON object
		writer.write("{");
		writer.write("\"ID\":" + arr[0] + ",");
		writer.write("\"Name\":\"" + arr[1] + "\",");
		writer.write("\"Age\":" + arr[2] + ",");
		writer.write("\"Marks\":" + arr[3]);
		writer.write("}\n");
	    }

	    System.out.println("CSV to JSON conversion completed");

	} catch (IOException e) {
	    System.out.println("Error converting CSV to JSON");
	}
    }
}
