package com.scenariobasedquestion.campusconnect;

import java.util.ArrayList;

// Faculty class extends Person
public class Faculty extends Person {
	private String department;
	private ArrayList<Course> coursesTeaching;
	
	public Faculty(String name, String email, String id, String department) {
		super(name, email, id);
		this.department = department;
		this.coursesTeaching = new ArrayList<>();
	}
	
	public void assignCourse(Course course) {
		if (!coursesTeaching.contains(course)) {
			coursesTeaching.add(course);
			course.setFaculty(this);
			System.out.println(name + " assigned to teach " + course.getCourseName());
		}
	}
	
	@Override
	public void printDetails() {
		System.out.println("\n=== Faculty Details ===");
		super.printDetails();
		System.out.println("Department: " + department);
		System.out.println("Courses Teaching: " + coursesTeaching.size());
	}
	
	public String getDepartment() {
		return department;
	}
	
	public ArrayList<Course> getCoursesTeaching() {
		return coursesTeaching;
	}
}
