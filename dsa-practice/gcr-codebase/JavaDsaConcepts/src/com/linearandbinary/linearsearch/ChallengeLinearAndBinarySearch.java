package com.linearandbinary.linearsearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Challenge Problem: Find First Missing Positive Integer (Linear Search) 
 * and Target Index (Binary Search)
 */
public class ChallengeLinearAndBinarySearch {
    
    // Linear Search: Find first missing positive integer
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        
        // Step 1: Mark numbers in valid range (1 to n)
        for (int i = 0; i < n; i++) {
            // Place each number at its correct position (number-1 index)
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] with arr[arr[i] - 1]
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        
        // Step 2: Find first missing positive
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If all positions filled, missing number is n+1
        return n + 1;
    }
    
    // Binary Search: Find index of target in sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Not found
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("  CHALLENGE: Linear + Binary Search");
        System.out.println("========================================");
        
        System.out.print("Enter the size of array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("\nEnter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        
        // Display original array
        System.out.print("\nOriginal Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // PART 1: Linear Search for first missing positive
        System.out.println("\n===== PART 1: Find First Missing Positive =====");
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        int missingPositive = findFirstMissingPositive(arrCopy);
        System.out.println("First Missing Positive Integer: " + missingPositive);
        
        // PART 2: Binary Search for target
        System.out.println("\n===== PART 2: Binary Search for Target =====");
        
        // Sort array for binary search
        Arrays.sort(arr);
        System.out.print("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.print("\nEnter target number to search: ");
        int target = scanner.nextInt();
        
        int index = binarySearch(arr, target);
        
        if (index != -1) {
            System.out.println("\n✓ Target " + target + " found at index " + index);
        } else {
            System.out.println("\n✗ Target " + target + " not found in array.");
        }
        
        System.out.println("\n===== CHALLENGE COMPLETE =====");
        
        scanner.close();
    }
}
