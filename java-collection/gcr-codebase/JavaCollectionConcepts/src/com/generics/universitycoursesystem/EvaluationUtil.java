package com.generics.universitycoursesystem;

import java.util.List;

public class EvaluationUtil {

	// Upper bounded wildcard allows handling any CourseType subclass list
	public static void displayEvaluations(List<? extends CourseType> evaluations) {
		System.out.println("--- All Evaluation Types ---");
		if (evaluations.isEmpty()) {
			System.out.println("No evaluations found.");
			return;
		}
		for (CourseType eval : evaluations) {
			System.out.println("  - " + eval);
		}
		System.out.println();
	}
}