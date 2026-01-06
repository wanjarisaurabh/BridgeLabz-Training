package com.scenariobasedquestion.campusconnect;

import java.util.ArrayList;

// Course class manages students and faculty
public class Course {
	private String courseCode;
	private String courseName;
	private int credits;
	private Faculty faculty;
	private ArrayList<Student> students;
	
	public Course(String courseCode, String courseName, int credits) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.credits = credits;
		this.students = new ArrayList<>();
	}
	
	public void addStudent(Student student) {
		if (!students.contains(student)) {
			students.add(student);
		}
	}
	
	public void removeStudent(Student student) {
		students.remove(student);
	}
	
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	public void displayCourseInfo() {
		System.out.println("\n=== Course Information ===");
		System.out.println("Course Code: " + courseCode);
		System.out.println("Course Name: " + courseName);
		System.out.println("Credits: " + credits);
		System.out.println("Faculty: " + (faculty != null ? faculty.getName() : "Not Assigned"));
		System.out.println("Enrolled Students: " + students.size());
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public int getCredits() {
		return credits;
	}
	
	public Faculty getFaculty() {
		return faculty;
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
}
