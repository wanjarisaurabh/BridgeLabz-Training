package com.generics.universitycoursesystem;

public class ResearchCourse extends CourseType {
	private String researchArea;

	// Constructor
	public ResearchCourse(String researchArea) {
		this.researchArea = researchArea;
	}

	@Override
	public String getEvaluationType() {
		return "Research-Based (Area: " + researchArea + ")";
	}

	// good string representation
	@Override
	public String toString() {
		return getEvaluationType();
	}
}