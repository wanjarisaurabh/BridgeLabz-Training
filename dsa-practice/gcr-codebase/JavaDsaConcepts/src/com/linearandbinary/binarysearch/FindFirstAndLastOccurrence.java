package com.linearandbinary.binarysearch;

import java.util.Scanner;

/**
 * Problem: Find First and Last Occurrence of an Element using Binary Search
 * Returns indices of first and last occurrence in sorted array
 */
public class FindFirstAndLastOccurrence {
    
    // Find first occurrence
    public static int findFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching on left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    // Find last occurrence
    public static int findLast(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching on right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Binary Search: First and Last Occurrence =====");
        System.out.print("Enter the size of sorted array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " elements (sorted):");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        
        // Display array
        System.out.print("\nSorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.print("\nEnter target element to find: ");
        int target = scanner.nextInt();
        
        // Find first and last occurrence
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        
        System.out.println("\n===== RESULT =====");
        if (first != -1) {
            System.out.println("✓ Element " + target + " found!");
            System.out.println("  First Occurrence: Index " + first);
            System.out.println("  Last Occurrence:  Index " + last);
            System.out.println("  Total Occurrences: " + (last - first + 1));
        } else {
            System.out.println("✗ Element " + target + " not found in array.");
        }
        
        scanner.close();
    }
}
