package com.linearandbinary.binarysearch;

import java.util.Scanner;

/**
 * Problem: Find the Rotation Point in a Rotated Sorted Array using Binary Search
 * Finds the index of the smallest element (rotation point)
 */
public class FindRotationPoint {
    
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        // If array is not rotated
        if (arr[left] < arr[right]) {
            return 0;
        }
        
        // Binary search for rotation point
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If mid element is greater than right element,
            // rotation point is in right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // Rotation point is in left half
                right = mid;
            }
        }
        
        return left;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Binary Search: Find Rotation Point =====");
        System.out.print("Enter the size of rotated sorted array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " elements (rotated sorted array):");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        
        // Display array
        System.out.print("\nRotated Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Find rotation point
        int rotationPoint = findRotationPoint(arr);
        
        System.out.println("\n===== RESULT =====");
        System.out.println("Rotation Point Index: " + rotationPoint);
        System.out.println("Smallest Element: " + arr[rotationPoint]);
        
        scanner.close();
    }
}
