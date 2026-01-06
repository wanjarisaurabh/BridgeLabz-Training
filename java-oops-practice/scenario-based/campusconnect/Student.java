package com.scenariobasedquestion.campusconnect;

import java.util.ArrayList;

// Student class extends Person and implements ICourseActions
public class Student extends Person implements ICourseActions {
	private ArrayList<Course> enrolledCourses;
	private ArrayList<Integer> grades; // Private as per requirement
	
	public Student(String name, String email, String id) {
		super(name, email, id);
		this.enrolledCourses = new ArrayList<>();
		this.grades = new ArrayList<>();
	}
	
	@Override
	public void enrollCourse(Course course) {
		if (!enrolledCourses.contains(course)) {
			enrolledCourses.add(course);
			course.addStudent(this);
			System.out.println(name + " enrolled in " + course.getCourseName());
		} else {
			System.out.println(name + " is already enrolled in " + course.getCourseName());
		}
	}
	
	@Override
	public void dropCourse(Course course) {
		if (enrolledCourses.contains(course)) {
			enrolledCourses.remove(course);
			course.removeStudent(this);
			System.out.println(name + " dropped " + course.getCourseName());
		} else {
			System.out.println(name + " is not enrolled in " + course.getCourseName());
		}
	}
	
	public void addGrade(int grade) {
		if (grade >= 0 && grade <= 100) {
			grades.add(grade);
		}
	}
	
	// Calculate GPA using operators (scale: 0-4.0)
	public double calculateGPA() {
		if (grades.isEmpty()) {
			return 0.0;
		}
		
		int total = 0;
		for (int grade : grades) {
			total += grade;
		}
		
		double average = (double) total / grades.size();
		return (average / 100) * 4.0; // Convert to 4.0 scale
	}
	
	@Override
	public void printDetails() {
		System.out.println("\n=== Student Details ===");
		super.printDetails();
		System.out.println("Enrolled Courses: " + enrolledCourses.size());
		System.out.println("GPA: " + String.format("%.2f", calculateGPA()));
	}
	
	public ArrayList<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
}
