package com.scenariobasedquestion.campusconnect;

public class CampusConnectDemo {
	public static void main(String[] args) {
		System.out.println("=== CampusConnect - College Information System ===\n");
		
		// Create students
		Student student1 = new Student("John Doe", "john@college.edu", "S001");
		Student student2 = new Student("Jane Smith", "jane@college.edu", "S002");
		
		// Add grades for student1
		student1.addGrade(85);
		student1.addGrade(90);
		student1.addGrade(78);
		
		// Create faculty
		Faculty faculty1 = new Faculty("Dr. Robert Brown", "robert@college.edu", "F001", "Computer Science");
		Faculty faculty2 = new Faculty("Dr. Emily White", "emily@college.edu", "F002", "Mathematics");
		
		// Create courses
		Course course1 = new Course("CS101", "Introduction to Programming", 4);
		Course course2 = new Course("MATH201", "Calculus I", 3);
		Course course3 = new Course("CS202", "Data Structures", 4);
		
		// Assign faculty to courses
		faculty1.assignCourse(course1);
		faculty1.assignCourse(course3);
		faculty2.assignCourse(course2);
		
		// Students enroll in courses
		System.out.println("\n--- Course Enrollment ---");
		student1.enrollCourse(course1);
		student1.enrollCourse(course2);
		student2.enrollCourse(course1);
		student2.enrollCourse(course3);
		
		// Try enrolling again (should show already enrolled)
		student1.enrollCourse(course1);
		
		// Display details using polymorphism
		student1.printDetails();
		student2.printDetails();
		faculty1.printDetails();
		faculty2.printDetails();
		
		// Display course information
		course1.displayCourseInfo();
		course2.displayCourseInfo();
		course3.displayCourseInfo();
		
		// Drop a course
		System.out.println("\n--- Dropping Course ---");
		student1.dropCourse(course2);
		
		course2.displayCourseInfo();
	}
}
