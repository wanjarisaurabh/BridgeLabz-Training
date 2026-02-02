package com.methodreferences.nameuppercasing;

import java.util.ArrayList;
import java.util.List;

public class NameUppercasingApp {
    public static void main(String[] args) {
        // sample employee list
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Aarav Sharma", "Engineering", 85000.0));
        employees.add(new Employee("Priya Patel", "Marketing", 62000.0));
        employees.add(new Employee("Rahul Verma", "Finance", 92000.0));
        employees.add(new Employee("Sneha Gupta", "HR", 58000.0));
        employees.add(new Employee("Vikram Singh", "Operations", 75000.0));

        System.out.println("HR Letter Preparation - Employee Names in Uppercase");
        System.out.println("--------------------------------------------------");

        // Use method reference String::toUpperCase in stream
        employees.stream()
                .map(emp -> emp.getName()) // get name
                .map(String::toUpperCase) // method reference
                .forEach(System.out::println); // print each uppercase name

        System.out.println("--------------------------------------------------");
        System.out.println("Total employees: " + employees.size());
    }
}