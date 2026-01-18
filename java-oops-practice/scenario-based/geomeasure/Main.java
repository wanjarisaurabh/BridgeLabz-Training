package com.scenariobasedquestion.geomeasure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * GeoMeasure Solutions - Line Comparison Application
 * Main class with user input functionality
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Line> lines = new ArrayList<>();
        
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║   GeoMeasure Solutions - Line Comparator        ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        
        boolean continueProgram = true;
        
        while (continueProgram) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add a new line");
            System.out.println("2. Compare two lines");
            System.out.println("3. Display all lines");
            System.out.println("4. Compare all lines");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addLine(scanner, lines);
                    break;
                case 2:
                    compareTwoLines(scanner, lines);
                    break;
                case 3:
                    displayAllLines(lines);
                    break;
                case 4:
                    compareAllLines(lines);
                    break;
                case 5:
                    continueProgram = false;
                    System.out.println("\nThank you for using GeoMeasure Solutions!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Adds a new line to the list
     */
    private static void addLine(Scanner scanner, List<Line> lines) {
        System.out.println("\n--- Add New Line ---");
        System.out.print("Enter line name/identifier: ");
        String lineName = scanner.nextLine();
        
        System.out.print("Enter x1 coordinate: ");
        double x1 = scanner.nextDouble();
        
        System.out.print("Enter y1 coordinate: ");
        double y1 = scanner.nextDouble();
        
        System.out.print("Enter x2 coordinate: ");
        double x2 = scanner.nextDouble();
        
        System.out.print("Enter y2 coordinate: ");
        double y2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        Line line = new Line(x1, y1, x2, y2, lineName);
        lines.add(line);
        
        System.out.println("\n✓ Line added successfully!");
        System.out.println(line);
    }
    
    /**
     * Compares two specific lines chosen by user
     */
    private static void compareTwoLines(Scanner scanner, List<Line> lines) {
        if (lines.size() < 2) {
            System.out.println("\n⚠ Need at least 2 lines to compare. Please add more lines.");
            return;
        }
        
        System.out.println("\n--- Compare Two Lines ---");
        displayAllLines(lines);
        
        System.out.print("\nEnter the index of first line (1-" + lines.size() + "): ");
        int index1 = scanner.nextInt() - 1;
        
        System.out.print("Enter the index of second line (1-" + lines.size() + "): ");
        int index2 = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        
        if (index1 >= 0 && index1 < lines.size() && index2 >= 0 && index2 < lines.size()) {
            Line line1 = lines.get(index1);
            Line line2 = lines.get(index2);
            
            System.out.println("\n--- Comparison Result ---");
            System.out.println(line1.compareTo(line2));
        } else {
            System.out.println("\n⚠ Invalid indices. Please try again.");
        }
    }
    
    /**
     * Displays all stored lines
     */
    private static void displayAllLines(List<Line> lines) {
        if (lines.isEmpty()) {
            System.out.println("\n⚠ No lines stored yet.");
            return;
        }
        
        System.out.println("\n--- All Lines ---");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ". " + lines.get(i));
        }
    }
    
    /**
     * Compares all lines with each other (Bonus feature)
     */
    private static void compareAllLines(List<Line> lines) {
        if (lines.size() < 2) {
            System.out.println("\n⚠ Need at least 2 lines to compare.");
            return;
        }
        
        System.out.println("\n--- Comparing All Lines ---");
        for (int i = 0; i < lines.size(); i++) {
            for (int j = i + 1; j < lines.size(); j++) {
                System.out.println(lines.get(i).compareTo(lines.get(j)));
            }
        }
        
        // Find longest and shortest
        Line longest = lines.get(0);
        Line shortest = lines.get(0);
        
        for (Line line : lines) {
            if (line.calculateLength() > longest.calculateLength()) {
                longest = line;
            }
            if (line.calculateLength() < shortest.calculateLength()) {
                shortest = line;
            }
        }
        
        System.out.println("\n📏 Summary:");
        System.out.println("Longest: " + longest);
        System.out.println("Shortest: " + shortest);
    }
}
