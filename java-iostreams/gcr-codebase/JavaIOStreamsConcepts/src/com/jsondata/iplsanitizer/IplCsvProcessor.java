package com.jsondata.iplsanitizer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IplCsvProcessor {
    // Reads CSV, applies censorship, writes CSV
    public static void process() {
	// sample files paths
	String inputFile = "samplefiles/iplsanitizer/ipl.csv";
	String outputFile = "samplefiles/iplsanitizer/ipl-censored.csv";

	List<String[]> rows = new ArrayList<>();
	try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

	    String header = reader.readLine();
	    String line;
	    
	    while ((line = reader.readLine()) != null) {

		String[] parts = line.split(",");
		parts[1] = CensorUtil.maskTeamName(parts[1]);
		parts[2] = CensorUtil.maskTeamName(parts[2]);
		parts[5] = CensorUtil.maskTeamName(parts[5]);
		parts[6] = CensorUtil.redactPlayer();

		rows.add(parts);
	    }

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

		writer.write(header);
		writer.newLine();

		for (String[] row : rows) {
		    writer.write(String.join(",", row));
		    writer.newLine();
		}
	    }
	    System.out.println("Censored CSV file generated.");

	} catch (Exception e) {
	    System.out.println("Error processing CSV file.");
	    System.out.println(e.getMessage());
	}
    }
}
