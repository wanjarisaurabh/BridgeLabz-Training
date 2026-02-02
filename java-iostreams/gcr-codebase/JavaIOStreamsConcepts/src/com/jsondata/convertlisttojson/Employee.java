package com.jsondata.convertlisttojson;

public class Employee {
    private int id;
    private String name;
    private String department;

    // constructor
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Default constructor required by Jackson
    public Employee() {
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
