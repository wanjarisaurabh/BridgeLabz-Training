package com.generics.universitycoursesystem;

public abstract class CourseType {

	// Subclasses define evaluation type
	public abstract String getEvaluationType();

	// good string representation
	@Override
	public String toString() {
		return getEvaluationType();
	}
}