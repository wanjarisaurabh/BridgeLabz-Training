package com.scenariobasedquestion.edumentor;

import java.util.ArrayList;

// Quiz class with encapsulated answers
public class Quiz {
	private String title;
	private String difficulty; // easy, medium, hard
	private int totalQuestions;
	private ArrayList<String> questions; // Private - internal question bank
	private ArrayList<String> correctAnswers; // Encapsulated - can't be modified once set
	private ArrayList<String> userAnswers;
	private int score;
	
	// Constructor with variable difficulty
	public Quiz(String title, String difficulty, int totalQuestions) {
		this.title = title;
		this.difficulty = difficulty;
		this.totalQuestions = totalQuestions;
		this.questions = new ArrayList<>();
		this.correctAnswers = new ArrayList<>();
		this.userAnswers = new ArrayList<>();
		this.score = 0;
	}
	
	// Add question with answer (can only be done once)
	public void addQuestion(String question, String answer) {
		if (questions.size() < totalQuestions) {
			questions.add(question);
			correctAnswers.add(answer);
		}
	}
	
	// Submit user answer
	public void submitAnswer(String answer) {
		if (userAnswers.size() < totalQuestions) {
			userAnswers.add(answer);
		}
	}
	
	// Calculate score using operators
	public void calculateScore() {
		score = 0;
		int minSize = Math.min(userAnswers.size(), correctAnswers.size());
		
		for (int i = 0; i < minSize; i++) {
			if (userAnswers.get(i).equalsIgnoreCase(correctAnswers.get(i))) {
				score++; // Using operator
			}
		}
	}
	
	// Generate percentage using operators
	public double getPercentage() {
		if (totalQuestions == 0) {
			return 0.0;
		}
		return ((double) score / totalQuestions) * 100; // Using operators
	}
	
	public void displayResults() {
		System.out.println("\n--- Quiz Results ---");
		System.out.println("Title: " + title);
		System.out.println("Difficulty: " + difficulty);
		System.out.println("Score: " + score + "/" + totalQuestions);
		System.out.println("Percentage: " + String.format("%.2f", getPercentage()) + "%");
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public int getTotalQuestions() {
		return totalQuestions;
	}
	
	public int getScore() {
		return score;
	}
}
