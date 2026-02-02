package com.methodreferences.nameuppercasing;

public class Employee {
    private String name;
    private String department;
    private double salary;

    // constructor
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // good string representation
    @Override
    public String toString() {
        return name + " (" + department + ", Rs." + String.format("%.2f", salary) + ")";
    }
}