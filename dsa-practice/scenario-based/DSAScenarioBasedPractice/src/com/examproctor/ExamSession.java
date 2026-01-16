package com.examproctor;

import java.util.HashMap;
import java.util.Stack;

//class to represent student's exam session
public class ExamSession {
	//student details
	String studentName;
	String rollNumber;
	
	//stack to track navigation
	Stack<Integer> navigationStack;
	
	//hashmap to store answers
	HashMap<Integer, Character> answers;
	
	//exam questions
	HashMap<Integer, Question> examQuestions;
	
	//exam state
	boolean isSubmitted;
	int score;
	
	public ExamSession(String studentName, String rollNumber) {
		this.studentName = studentName;
		this.rollNumber = rollNumber;
		this.navigationStack = new Stack<>();
		this.answers = new HashMap<>();
		this.examQuestions = new HashMap<>();
		this.isSubmitted = false;
		this.score = 0;
	}
	
	//method to add question to exam
	public void addQuestion(Question question) {
		examQuestions.put(question.questionId, question);
	}
	
	//method to visit question
	public void visitQuestion(int questionId) {
		if (!examQuestions.containsKey(questionId)) {
			System.out.println("Question " + questionId + " does not exist");
			return;
		}
		
		navigationStack.push(questionId);
		examQuestions.get(questionId).displayQuestion();
		
		//show if already answered
		if (answers.containsKey(questionId)) {
			System.out.println("Current Answer: " + answers.get(questionId));
		}
	}
	
	//method to answer question
	public void answerQuestion(int questionId, char answer) {
		if (!examQuestions.containsKey(questionId)) {
			System.out.println("Question " + questionId + " does not exist");
			return;
		}
		
		//validate answer
		answer = Character.toUpperCase(answer);
		if (answer < 'A' || answer > 'D') {
			System.out.println("Invalid answer. Please choose A, B, C, or D");
			return;
		}
		
		answers.put(questionId, answer);
		System.out.println("✓ Answer saved for Question " + questionId);
	}
	
	//method to go back to last visited question
	public void goBack() {
		if (navigationStack.isEmpty()) {
			System.out.println("No previous question to go back to");
			return;
		}
		
		navigationStack.pop(); //remove current
		
		if (navigationStack.isEmpty()) {
			System.out.println("No previous question");
			return;
		}
		
		int lastQuestionId = navigationStack.peek();
		System.out.println("Going back to Question " + lastQuestionId);
		examQuestions.get(lastQuestionId).displayQuestion();
		
		if (answers.containsKey(lastQuestionId)) {
			System.out.println("Current Answer: " + answers.get(lastQuestionId));
		}
	}
	
	//method to show navigation history
	public void showNavigationHistory() {
		if (navigationStack.isEmpty()) {
			System.out.println("No navigation history");
			return;
		}
		
		System.out.println("\n===== NAVIGATION HISTORY =====");
		System.out.print("Questions Visited: ");
		
		for (Integer questionId : navigationStack) {
			System.out.print(questionId + " → ");
		}
		System.out.println("Current");
	}
	
	//method to submit exam
	public void submitExam() {
		if (isSubmitted) {
			System.out.println("Exam already submitted");
			return;
		}
		
		System.out.println("\n===== SUBMITTING EXAM =====");
		System.out.println("Student: " + studentName + " (" + rollNumber + ")");
		System.out.println("Questions Answered: " + answers.size() + "/" + examQuestions.size());
		
		//calculate score
		score = calculateScore();
		isSubmitted = true;
		
		System.out.println("✓ Exam submitted successfully");
	}
	
	//function to calculate score
	private int calculateScore() {
		int totalScore = 0;
		int maxScore = examQuestions.size() * 10; //10 marks per question
		
		for (Integer questionId : answers.keySet()) {
			Question question = examQuestions.get(questionId);
			char studentAnswer = answers.get(questionId);
			
			if (studentAnswer == question.correctAnswer) {
				totalScore += 10;
			}
		}
		
		System.out.println("\n--- Score Calculation ---");
		System.out.println("Correct Answers: " + (totalScore / 10) + "/" + examQuestions.size());
		System.out.println("Total Score: " + totalScore + "/" + maxScore);
		System.out.println("Percentage: " + String.format("%.2f", (totalScore * 100.0) / maxScore) + "%");
		
		return totalScore;
	}
	
	//method to show exam summary
	public void showExamSummary() {
		if (!isSubmitted) {
			System.out.println("Exam not yet submitted");
			return;
		}
		
		System.out.println("\n╔════════════════════════════════╗");
		System.out.println("║       EXAM SUMMARY            ║");
		System.out.println("╠════════════════════════════════╣");
		System.out.println("║ Student: " + String.format("%-20s", studentName) + "║");
		System.out.println("║ Roll No: " + String.format("%-20s", rollNumber) + "║");
		System.out.println("╠════════════════════════════════╣");
		
		int correct = score / 10;
		int total = examQuestions.size();
		
		System.out.println("║ Questions: " + total + "                    ║");
		System.out.println("║ Answered: " + answers.size() + "                     ║");
		System.out.println("║ Correct: " + correct + "                      ║");
		System.out.println("║ Score: " + score + "/" + (total * 10) + "                  ║");
		System.out.println("╚════════════════════════════════╝");
	}
	
	//method to show all answers
	public void showAnswers() {
		if (answers.isEmpty()) {
			System.out.println("No answers recorded yet");
			return;
		}
		
		System.out.println("\n===== YOUR ANSWERS =====");
		for (Integer questionId : answers.keySet()) {
			System.out.println("Question " + questionId + ": " + answers.get(questionId));
		}
	}
}
