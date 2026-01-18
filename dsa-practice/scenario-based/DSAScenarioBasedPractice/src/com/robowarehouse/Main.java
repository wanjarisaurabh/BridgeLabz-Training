package com.robowarehouse;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number of packages: ");
		int n = input.nextInt();
		
		Package[] shelf = new Package[n];
		
		// input packages
		for (int i = 0; i < n; i++) {
			System.out.println("Enter package name: ");
			String name = input.next();
			
			System.out.println("Enter weight (kg): ");
			double weight = input.nextDouble();
			
			shelf[i] = new Package(name, weight);
		}
		
		// sort by weight using insertion sort
		Package.loadShelf(shelf, n);
		
		// display sorted shelf
		System.out.println("\n=== SHELF LOADING ORDER (Ascending Weight) ===");
		System.out.printf("%-15s %-10s\n", "Package", "Weight(kg)");
		System.out.println("--------------------------------");
		
		for (int i = 0; i < n; i++) {
			System.out.printf("%-15s %-10.2f\n", shelf[i].name, shelf[i].weight);
		}
		
		input.close();
	}
}
