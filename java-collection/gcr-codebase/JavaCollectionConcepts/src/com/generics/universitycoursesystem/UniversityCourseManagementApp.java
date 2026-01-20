/*
	3. Multi-Level University Course Management System
	Concepts: 
		Generic Classes, Wildcards, Bounded Type Parameters	Problem Statement:
		Develop a university course management system where different departments offer courses with different evaluation types 
		(e.g., Exam-Based, Assignment-Based, Research-Based).
	Hints:
		Create an abstract class CourseType (e.g., ExamCourse, AssignmentCourse, ResearchCourse).
		Implement a generic class Course<T extends CourseType> to manage different courses.
		Use wildcards (List<? extends CourseType>) to handle any type of course dynamically.
*/

package com.generics.universitycoursesystem;

import java.util.ArrayList;
import java.util.List;

public class UniversityCourseManagementApp {
	public static void main(String[] args) {
		System.out.println("Multi-Level University Course Management System\n");

		// Create departments (multi-level structure)
		Department cs = new Department("Computer Science");
		Department math = new Department("Mathematics");
		Department humanities = new Department("Humanities");

		// Add courses with different bounded evaluation types
		cs.addCourse(new Course<>("CS301", "Advanced Programming", new ExamCourse(3)));
		cs.addCourse(new Course<>("CS402", "Algorithms", new AssignmentCourse(8)));

		math.addCourse(new Course<>("MATH201", "Calculus II", new ExamCourse(4)));
		math.addCourse(new Course<>("MATH501", "Advanced Topics", new ResearchCourse("Number Theory")));

		humanities.addCourse(new Course<>("HUM101", "World Literature", new AssignmentCourse(6)));
		humanities.addCourse(new Course<>("HUM601", "Thesis Research", new ResearchCourse("Cultural Studies")));

		// Display individual departments
		cs.display();
		math.display();
		humanities.display();

		// Collect all evaluations dynamically (type-safe via polymorphism)
		List<CourseType> allEvaluations = new ArrayList<>();
		for (Department dept : List.of(cs, math, humanities)) {
			for (Course<?> course : dept.getCourses()) {
				allEvaluations.add(course.getEvaluation());
			}
		}

		// Use wildcard method for flexible display
		EvaluationUtil.displayEvaluations(allEvaluations);

		// Type safety demonstration (compile errors)
		// new Course<>("INVALID", "Test", new String("wrong"));
		// Error: String not extends CourseType
	}
}