package com.jsondata.listtojson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertListToJson {
    public static void main(String[] args) {
	// Sample file path
	String filePath = "samplefiles/listtojson/employees.json";

	// Create list of objects
	List<Employee> employees = new ArrayList<>();

	employees.add(new Employee(101, "Amit", "IT"));
	employees.add(new Employee(102, "Neha", "HR"));
	employees.add(new Employee(103, "Rahul", "Finance"));

	ObjectMapper mapper = new ObjectMapper();

	try {
	    // Convert list to JSON array and write to file
	    mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), employees);

	    System.out.println("Employee list converted to JSON successfully.");

	} catch (IOException e) {
	    System.out.println("Error converting list to JSON.");
	    System.out.println(e.getMessage());
	}
    }
}
