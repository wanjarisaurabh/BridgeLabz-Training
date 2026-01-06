package com.scenariobasedquestion.edumentor;

import java.util.ArrayList;

// Learner class extends User and implements ICertifiable
public class Learner extends User implements ICertifiable {
	private ArrayList<Quiz> completedQuizzes;
	private String courseType; // "short" or "fulltime"
	private double overallScore;
	
	public Learner(String name, String email, String userId, String courseType) {
		super(name, email, userId);
		this.completedQuizzes = new ArrayList<>();
		this.courseType = courseType;
		this.overallScore = 0.0;
	}
	
	public void takeQuiz(Quiz quiz) {
		completedQuizzes.add(quiz);
		calculateOverallScore();
		System.out.println(name + " completed quiz: " + quiz.getTitle());
	}
	
	private void calculateOverallScore() {
		if (completedQuizzes.isEmpty()) {
			overallScore = 0.0;
			return;
		}
		
		double total = 0.0;
		for (Quiz quiz : completedQuizzes) {
			total += quiz.getPercentage();
		}
		overallScore = total / completedQuizzes.size();
	}
	
	@Override
	public void generateCertificate() {
		System.out.println("\n========== CERTIFICATE ==========");
		System.out.println("This is to certify that");
		System.out.println(name.toUpperCase());
		System.out.println("has successfully completed");
		
		// Polymorphism: different certificate for different course types
		if (courseType.equalsIgnoreCase("short")) {
			System.out.println("SHORT COURSE");
			System.out.println("Duration: 4 weeks");
		} else if (courseType.equalsIgnoreCase("fulltime")) {
			System.out.println("FULL-TIME PROGRAM");
			System.out.println("Duration: 6 months");
		}
		
		System.out.println("Score: " + String.format("%.2f", overallScore) + "%");
		System.out.println("=================================\n");
	}
	
	@Override
	public void displayInfo() {
		System.out.println("\n--- Learner Profile ---");
		super.displayInfo();
		System.out.println("Course Type: " + courseType);
		System.out.println("Quizzes Completed: " + completedQuizzes.size());
		System.out.println("Overall Score: " + String.format("%.2f", overallScore) + "%");
	}
	
	public double getOverallScore() {
		return overallScore;
	}
}
