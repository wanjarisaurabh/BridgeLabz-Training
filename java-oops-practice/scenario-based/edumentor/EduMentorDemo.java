package com.scenariobasedquestion.edumentor;

public class EduMentorDemo {
	public static void main(String[] args) {
		System.out.println("=== EduMentor - Personalized Learning Platform ===\n");
		
		// Create instructor
		Instructor instructor = new Instructor("Dr. Sarah Johnson", "sarah@edumentor.com", "I001", "Data Science");
		instructor.displayInfo();
		
		// Instructor creates quizzes
		System.out.println("\n--- Creating Quizzes ---");
		Quiz quiz1 = instructor.createQuiz("Python Basics", "easy", 5);
		Quiz quiz2 = instructor.createQuiz("Machine Learning Fundamentals", "hard", 10);
		
		// Add questions to quiz1
		quiz1.addQuestion("What is Python?", "A");
		quiz1.addQuestion("What is a variable?", "B");
		quiz1.addQuestion("What is a loop?", "C");
		quiz1.addQuestion("What is a function?", "A");
		quiz1.addQuestion("What is OOP?", "B");
		
		// Add questions to quiz2
		for (int i = 0; i < 10; i++) {
			quiz2.addQuestion("ML Question " + (i + 1), "A");
		}
		
		// Create learners
		Learner learner1 = new Learner("Alice Brown", "alice@student.com", "L001", "short");
		Learner learner2 = new Learner("Bob Wilson", "bob@student.com", "L002", "fulltime");
		
		learner1.displayInfo();
		learner2.displayInfo();
		
		// Learner 1 takes quiz1
		System.out.println("\n--- Learner 1 Taking Quiz ---");
		quiz1.submitAnswer("A");
		quiz1.submitAnswer("B");
		quiz1.submitAnswer("C");
		quiz1.submitAnswer("A");
		quiz1.submitAnswer("B");
		quiz1.calculateScore();
		learner1.takeQuiz(quiz1);
		quiz1.displayResults();
		
		// Learner 2 takes quiz2
		System.out.println("\n--- Learner 2 Taking Quiz ---");
		for (int i = 0; i < 10; i++) {
			if (i < 7) {
				quiz2.submitAnswer("A"); // Correct
			} else {
				quiz2.submitAnswer("B"); // Wrong
			}
		}
		quiz2.calculateScore();
		learner2.takeQuiz(quiz2);
		quiz2.displayResults();
		
		// Generate certificates (Polymorphism)
		System.out.println("\n--- Generating Certificates ---");
		learner1.generateCertificate();
		learner2.generateCertificate();
		instructor.generateCertificate();
	}
}
