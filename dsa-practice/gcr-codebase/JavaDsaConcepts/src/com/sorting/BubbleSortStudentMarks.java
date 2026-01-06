package com.sorting;

public class Q1_BubbleSortStudentMarks {
    
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) break;
        }
    }
    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] studentMarks = {78, 55, 92, 45, 88, 67, 73, 95, 60};
        
        System.out.println("Original Student Marks:");
        printArray(studentMarks);
        
        bubbleSort(studentMarks);
        
        System.out.println("\nSorted Student Marks (Ascending Order):");
        printArray(studentMarks);
        
        // Test Case 2
        int[] marks2 = {100, 95, 90, 85, 80};
        System.out.println("\nAlready Sorted Marks:");
        printArray(marks2);
        bubbleSort(marks2);
        System.out.println("After Bubble Sort:");
        printArray(marks2);
    }
}
