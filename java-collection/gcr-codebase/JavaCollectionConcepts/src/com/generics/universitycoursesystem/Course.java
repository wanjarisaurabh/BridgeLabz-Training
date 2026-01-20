package com.generics.universitycoursesystem;

public class Course<T extends CourseType> {
	private String code;
	private String title;
	private T evaluation;

	// Constructor
	public Course(String code, String title, T evaluation) {
		this.code = code;
		this.title = title;
		this.evaluation = evaluation;
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	// Returns bounded evaluation object
	public T getEvaluation() {
		return evaluation;
	}

	// good string representation
	@Override
	public String toString() {
		return code + " - " + title + " [" + evaluation + "]";
	}
}