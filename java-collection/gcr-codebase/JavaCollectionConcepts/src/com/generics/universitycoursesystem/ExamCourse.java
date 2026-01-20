package com.generics.universitycoursesystem;

public class ExamCourse extends CourseType {
	private int numExams;

	// Constructor
	public ExamCourse(int numExams) {
		this.numExams = numExams;
	}

	@Override
	public String getEvaluationType() {
		return "Exam-Based (" + numExams + " exams)";
	}

	// good string representation
	@Override
	public String toString() {
		return getEvaluationType();
	}
}