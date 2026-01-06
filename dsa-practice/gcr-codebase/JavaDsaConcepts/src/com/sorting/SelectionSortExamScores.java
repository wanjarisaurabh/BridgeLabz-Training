package com.sorting;

import java.util.Scanner;

public class Q5_SelectionSortExamScores {
    
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }
    
    public static void printArray(int[] arr) {
        for (int score : arr) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        
        int[] examScores = new int[n];
        
        System.out.println("Enter " + n + " exam scores:");
        for (int i = 0; i < n; i++) {
            examScores[i] = sc.nextInt();
        }
        
        System.out.println("\nOriginal Exam Scores:");
        printArray(examScores);
        
        selectionSort(examScores);
        
        System.out.println("\nSorted Exam Scores (Ascending Order):");
        printArray(examScores);
        
        sc.close();
    }
}
