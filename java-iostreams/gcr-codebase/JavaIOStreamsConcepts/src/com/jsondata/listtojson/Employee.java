package com.jsondata.listtojson;

public class Employee {
    private int id;
    private String name;
    private String department;

    // Default constructor required by Jackson
    public Employee() {
    }

    // Constructor
    public Employee(int id, String name, String department) {
	this.id = id;
	this.name = name;
	this.department = department;
    }

    // Getter methods used during serialization
    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public String getDepartment() {
	return department;
    }
}
