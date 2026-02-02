package com.jsondata.dbreport;

public class EmployeeRecord {
    private int id;
    private String name;
    private String department;
    private double salary;

    // default constructor
    public EmployeeRecord() {
    }

    // parameterized constructor
    public EmployeeRecord(int id, String name, String department, double salary) {
	this.id = id;
	this.name = name;
	this.department = department;
	this.salary = salary;
    }

    // Getter methods used for JSON serialization
    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public String getDepartment() {
	return department;
    }

    public double getSalary() {
	return salary;
    }
}
