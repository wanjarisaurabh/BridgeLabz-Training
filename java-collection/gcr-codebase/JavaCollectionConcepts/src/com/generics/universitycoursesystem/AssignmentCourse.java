package com.generics.universitycoursesystem;

public class AssignmentCourse extends CourseType {
	private int numAssignments;

	// Constructor
	public AssignmentCourse(int numAssignments) {
		this.numAssignments = numAssignments;
	}

	@Override
	public String getEvaluationType() {
		return "Assignment-Based (" + numAssignments + " assignments)";
	}

	// good string representation
	@Override
	public String toString() {
		return getEvaluationType();
	}
}