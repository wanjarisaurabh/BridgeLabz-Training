package com.examproctor;

//class to represent a question
public class Question {
	//question details
	int questionId;
	String questionText;
	String optionA;
	String optionB;
	String optionC;
	String optionD;
	char correctAnswer;
	
	public Question(int questionId, String questionText, String optionA, String optionB, 
			String optionC, String optionD, char correctAnswer) {
		this.questionId = questionId;
		this.questionText = questionText;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctAnswer = correctAnswer;
	}
	
	//method to display question
	public void displayQuestion() {
		System.out.println("\n--- Question " + questionId + " ---");
		System.out.println(questionText);
		System.out.println("A) " + optionA);
		System.out.println("B) " + optionB);
		System.out.println("C) " + optionC);
		System.out.println("D) " + optionD);
	}
}
