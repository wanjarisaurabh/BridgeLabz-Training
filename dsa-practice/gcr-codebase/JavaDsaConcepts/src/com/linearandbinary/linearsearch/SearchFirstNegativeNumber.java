package com.linearandbinary.linearsearch;

import java.util.Scanner;

/**
 * Problem: Search for the First Negative Number using Linear Search
 * Returns the index of the first negative number in an array
 */
public class SearchFirstNegativeNumber {
    
    public static int findFirstNegative(int[] arr) {
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Check if current element is negative
            if (arr[i] < 0) {
                return i; // Return index
            }
        }
        
        // No negative number found
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Linear Search: Find First Negative Number =====");
        System.out.print("Enter the size of array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        
        // Display array
        System.out.print("\nArray: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Search for first negative
        int index = findFirstNegative(arr);
        
        if (index != -1) {
            System.out.println("\n✓ First negative number found at index " + index);
            System.out.println("  Value: " + arr[index]);
        } else {
            System.out.println("\n✗ No negative number found in the array.");
        }
        
        scanner.close();
    }
}
