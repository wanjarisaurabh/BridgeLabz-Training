package com.sorting;

import java.util.Scanner;

public class Q2_InsertionSortEmployeeIDs {
    
    public static void insertionSort(int[] ids) {
        int n = ids.length;
        
        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;
            
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }
    }
    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        
        int[] employeeIDs = new int[n];
        
        System.out.println("Enter " + n + " employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIDs[i] = sc.nextInt();
        }
        
        System.out.println("\nOriginal Employee IDs:");
        printArray(employeeIDs);
        
        insertionSort(employeeIDs);
        
        System.out.println("\nSorted Employee IDs (Ascending Order):");
        printArray(employeeIDs);
        
        sc.close();
    }
}
