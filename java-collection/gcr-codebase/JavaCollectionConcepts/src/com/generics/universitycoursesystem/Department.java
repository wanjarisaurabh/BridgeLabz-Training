package com.generics.universitycoursesystem;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	private List<Course<?>> courses = new ArrayList<>();

	// Constructor
	public Department(String name) {
		this.name = name;
	}

	// Adds any course type safely
	public void addCourse(Course<?> course) {
		courses.add(course);
	}

	public List<Course<?>> getCourses() {
		return courses;
	}

	// Displays department info
	public void display() {
		System.out.println("Department: " + name);
		for (Course<?> course : courses) {
			System.out.println("  " + course);
		}
		System.out.println();
	}
}