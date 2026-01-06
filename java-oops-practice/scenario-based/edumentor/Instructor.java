package com.scenariobasedquestion.edumentor;

import java.util.ArrayList;

// Instructor class extends User
public class Instructor extends User implements ICertifiable {
	private String specialization;
	private ArrayList<Quiz> createdQuizzes;
	
	public Instructor(String name, String email, String userId, String specialization) {
		super(name, email, userId);
		this.specialization = specialization;
		this.createdQuizzes = new ArrayList<>();
	}
	
	public Quiz createQuiz(String title, String difficulty, int totalQuestions) {
		Quiz quiz = new Quiz(title, difficulty, totalQuestions);
		createdQuizzes.add(quiz);
		System.out.println("Quiz created: " + title);
		return quiz;
	}
	
	@Override
	public void generateCertificate() {
		System.out.println("\n========== INSTRUCTOR CERTIFICATE ==========");
		System.out.println("This certifies that");
		System.out.println(name.toUpperCase());
		System.out.println("is a verified instructor at EduMentor");
		System.out.println("Specialization: " + specialization);
		System.out.println("Quizzes Created: " + createdQuizzes.size());
		System.out.println("============================================\n");
	}
	
	@Override
	public void displayInfo() {
		System.out.println("\n--- Instructor Profile ---");
		super.displayInfo();
		System.out.println("Specialization: " + specialization);
		System.out.println("Quizzes Created: " + createdQuizzes.size());
	}
	
	public String getSpecialization() {
		return specialization;
	}
}
