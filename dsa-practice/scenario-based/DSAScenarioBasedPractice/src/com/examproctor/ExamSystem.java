package com.examproctor;

import java.util.HashMap;

//class to manage exam system
public class ExamSystem {
	//hashmap to store all exam sessions
	private static HashMap<String, ExamSession> sessions = new HashMap<>();
	
	//hashmap to store question bank
	private static HashMap<Integer, Question> questionBank = new HashMap<>();
	
	//method to add question to question bank
	public static void addQuestionToBank(Question question) {
		if (questionBank.containsKey(question.questionId)) {
			System.out.println("Question with ID " + question.questionId + " already exists");
			return;
		}
		
		questionBank.put(question.questionId, question);
		System.out.println("✓ Question added to bank");
	}
	
	//method to create new exam session
	public static boolean createSession(String rollNumber, String studentName) {
		if (sessions.containsKey(rollNumber)) {
			System.out.println("Session already exists for roll number " + rollNumber);
			return false;
		}
		
		ExamSession session = new ExamSession(studentName, rollNumber);
		
		//add all questions from question bank to exam
		for (Question question : questionBank.values()) {
			session.addQuestion(question);
		}
		
		sessions.put(rollNumber, session);
		System.out.println("✓ Exam session created for " + studentName);
		return true;
	}
	
	//method to get session
	public static ExamSession getSession(String rollNumber) {
		if (!sessions.containsKey(rollNumber)) {
			System.out.println("No session found for roll number " + rollNumber);
			return null;
		}
		
		return sessions.get(rollNumber);
	}
	
	//method to show all sessions
	public static void showAllSessions() {
		if (sessions.isEmpty()) {
			System.out.println("No active sessions");
			return;
		}
		
		System.out.println("\n===== ALL SESSIONS =====");
		for (String rollNumber : sessions.keySet()) {
			ExamSession session = sessions.get(rollNumber);
			String status = session.isSubmitted ? "Submitted" : "In Progress";
			System.out.println("Roll: " + rollNumber + " | Student: " + session.studentName + 
					" | Status: " + status);
		}
	}
	
	//method to show question bank
	public static void showQuestionBank() {
		if (questionBank.isEmpty()) {
			System.out.println("No questions in question bank");
			return;
		}
		
		System.out.println("\n===== QUESTION BANK =====");
		for (Integer questionId : questionBank.keySet()) {
			Question question = questionBank.get(questionId);
			System.out.println("Q" + questionId + ": " + question.questionText);
		}
		System.out.println("Total Questions: " + questionBank.size());
	}
}
