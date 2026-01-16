package com.examproctor;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		//add sample questions
		setupSampleQuestions();
		
		int choice;

		do {
			System.out.println("\n===== EXAM PROCTOR SYSTEM =====");
			System.out.println("1. Create new exam session");
			System.out.println("2. Visit question");
			System.out.println("3. Answer question");
			System.out.println("4. Go back to previous question");
			System.out.println("5. Show navigation history");
			System.out.println("6. Show your answers");
			System.out.println("7. Submit exam");
			System.out.println("8. Show exam summary");
			System.out.println("9. Show all sessions");
			System.out.println("10. Add question to bank");
			System.out.println("11. Show question bank");
			System.out.println("0. Exit");
			System.out.print("Enter choice: ");

			choice = input.nextInt();

			switch (choice) {

				case 1:
					createNewSession(input);
					break;

				case 2:
					visitQuestion(input);
					break;

				case 3:
					answerQuestion(input);
					break;

				case 4:
					goBackToPrevious(input);
					break;

				case 5:
					showNavigationHistory(input);
					break;

				case 6:
					showAnswers(input);
					break;

				case 7:
					submitExam(input);
					break;

				case 8:
					showExamSummary(input);
					break;

				case 9:
					ExamSystem.showAllSessions();
					break;

				case 10:
					addQuestionToBank(input);
					break;

				case 11:
					ExamSystem.showQuestionBank();
					break;

				case 0:
					System.out.println("Exiting...");
					break;

				default:
					System.out.println("Invalid choice");
			}

		} while (choice != 0);

		input.close();
	}

	// -------- MENU OPERATIONS --------

	static void createNewSession(Scanner sc) {
		System.out.print("Enter roll number: ");
		String rollNumber = sc.next();

		System.out.print("Enter student name: ");
		sc.nextLine(); //consume newline
		String studentName = sc.nextLine();

		ExamSystem.createSession(rollNumber, studentName);
	}

	static void visitQuestion(Scanner sc) {
		System.out.print("Enter roll number: ");
		String rollNumber = sc.next();

		ExamSession session = ExamSystem.getSession(rollNumber);
		if (session == null) return;

		if (session.isSubmitted) {
			System.out.println("Exam already submitted. Cannot visit questions");
			return;
		}

		System.out.print("Enter question ID: ");
		int questionId = sc.nextInt();

		session.visitQuestion(questionId);
	}

	static void answerQuestion(Scanner sc) {
		System.out.print("Enter roll number: ");
		String rollNumber = sc.next();

		ExamSession session = ExamSystem.getSession(rollNumber);
		if (session == null) return;

		if (session.isSubmitted) {
			System.out.println("Exam already submitted. Cannot answer questions");
			return;
		}

		System.out.print("Enter question ID: ");
		int questionId = sc.nextInt();

		System.out.print("Enter your answer (A/B/C/D): ");
		char answer = sc.next().charAt(0);

		session.answerQuestion(questionId, answer);
	}

	static void goBackToPrevious(Scanner sc) {
		System.out.print("Enter roll number: ");
		String rollNumber = sc.next();

		ExamSession session = ExamSystem.getSession(rollNumber);
		if (session == null) return;

		if (session.isSubmitted) {
			System.out.println("Exam already submitted");
			return;
		}

		session.goBack();
	}

	static void showNavigationHistory(Scanner sc) {
		System.out.print("Enter roll number: ");
		String rollNumber = sc.next();

		ExamSession session = ExamSystem.getSession(rollNumber);
		if (session == null) return;

		session.showNavigationHistory();
	}

	static void showAnswers(Scanner sc) {
		System.out.print("Enter roll number: ");
		String rollNumber = sc.next();

		ExamSession session = ExamSystem.getSession(rollNumber);
		if (session == null) return;

		session.showAnswers();
	}

	static void submitExam(Scanner sc) {
		System.out.print("Enter roll number: ");
		String rollNumber = sc.next();

		ExamSession session = ExamSystem.getSession(rollNumber);
		if (session == null) return;

		session.submitExam();
	}

	static void showExamSummary(Scanner sc) {
		System.out.print("Enter roll number: ");
		String rollNumber = sc.next();

		ExamSession session = ExamSystem.getSession(rollNumber);
		if (session == null) return;

		session.showExamSummary();
	}

	static void addQuestionToBank(Scanner sc) {
		System.out.print("Enter question ID: ");
		int questionId = sc.nextInt();

		System.out.print("Enter question text: ");
		sc.nextLine(); //consume newline
		String questionText = sc.nextLine();

		System.out.print("Enter option A: ");
		String optionA = sc.nextLine();

		System.out.print("Enter option B: ");
		String optionB = sc.nextLine();

		System.out.print("Enter option C: ");
		String optionC = sc.nextLine();

		System.out.print("Enter option D: ");
		String optionD = sc.nextLine();

		System.out.print("Enter correct answer (A/B/C/D): ");
		char correctAnswer = sc.next().toUpperCase().charAt(0);

		Question question = new Question(questionId, questionText, optionA, optionB, 
				optionC, optionD, correctAnswer);

		ExamSystem.addQuestionToBank(question);
	}

	// -------- HELPER METHODS --------

	static void setupSampleQuestions() {
		//sample questions for testing
		Question q1 = new Question(1, "What is the capital of India?", 
				"Mumbai", "Delhi", "Kolkata", "Chennai", 'B');

		Question q2 = new Question(2, "What is 2 + 2?", 
				"3", "4", "5", "6", 'B');

		Question q3 = new Question(3, "Which data structure uses LIFO?", 
				"Queue", "Stack", "Array", "Tree", 'B');

		Question q4 = new Question(4, "What is the time complexity of Binary Search?", 
				"O(n)", "O(log n)", "O(n^2)", "O(1)", 'B');

		Question q5 = new Question(5, "Which language is used for Android development?", 
				"Python", "Java", "C++", "Ruby", 'B');

		ExamSystem.addQuestionToBank(q1);
		ExamSystem.addQuestionToBank(q2);
		ExamSystem.addQuestionToBank(q3);
		ExamSystem.addQuestionToBank(q4);
		ExamSystem.addQuestionToBank(q5);
	}
}
