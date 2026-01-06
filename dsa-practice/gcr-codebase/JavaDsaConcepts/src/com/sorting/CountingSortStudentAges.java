package com.sorting;

import java.util.Scanner;

public class Q7_CountingSortStudentAges {
    
    public static void countingSort(int[] ages) {
        int max = 18;
        int min = 10;
        int range = max - min + 1;
        
        int[] count = new int[range];
        int[] output = new int[ages.length];
        
        for (int age : ages) {
            count[age - min]++;
        }
        
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }
        
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }
    
    public static void printArray(int[] arr) {
        for (int age : arr) {
            System.out.print(age + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        
        int[] studentAges = new int[n];
        
        System.out.println("Enter " + n + " student ages (10-18):");
        for (int i = 0; i < n; i++) {
            studentAges[i] = sc.nextInt();
        }
        
        System.out.println("\nOriginal Student Ages:");
        printArray(studentAges);
        
        countingSort(studentAges);
        
        System.out.println("\nSorted Student Ages (Ascending Order):");
        printArray(studentAges);
        
        sc.close();
    }
}
