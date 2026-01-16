package com.examcell;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number of test centers: ");
		int centers = input.nextInt();
		
		int totalStudents = 0;
		
		// get student count from each center
		int[] centerCounts = new int[centers];
		for (int i = 0; i < centers; i++) {
			System.out.println("Enter number of students in center " + (i + 1) + ": ");
			centerCounts[i] = input.nextInt();
			totalStudents += centerCounts[i];
		}
		
		// create array for all students
		Student[] allStudents = new Student[totalStudents];
		int index = 0;
		
		// input students from each center
		for (int i = 0; i < centers; i++) {
			System.out.println("\nCenter " + (i + 1) + " students:");
			for (int j = 0; j < centerCounts[i]; j++) {
				System.out.println("Enter name: ");
				String name = input.next();
				
				System.out.println("Enter score: ");
				int score = input.nextInt();
				
				allStudents[index] = new Student(name, score, "Center-" + (i + 1));
				index++;
			}
		}
		
		// sort using merge sort
		Student.generateRanks(allStudents);
		
		// display rank list
		System.out.println("\n=== STATE LEVEL RANK LIST ===");
		System.out.printf("%-10s %-20s %-15s %-10s\n", "Rank", "Name", "Center", "Score");
		System.out.println("------------------------------------------------------------");
		
		for (int i = 0; i < allStudents.length; i++) {
			System.out.printf("%-10d %-20s %-15s %-10d\n", 
				(i + 1), 
				allStudents[i].name, 
				allStudents[i].center, 
				allStudents[i].score);
		}
		
		input.close();
	}
}
