package com.linearandbinary.binarysearch;

import java.util.Scanner;

/**
 * Problem: Find the Peak Element in an Array using Binary Search
 * A peak element is greater than its neighbors
 */
public class FindPeakElement {
    
    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is peak
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                }
            }
            
            // If left neighbor is greater, search left half
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Otherwise search right half
            else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Binary Search: Find Peak Element =====");
        System.out.print("Enter the size of array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter " + n + " elements:");
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
        
        // Find peak
        int peakIndex = findPeak(arr);
        
        System.out.println("\n===== RESULT =====");
        System.out.println("Peak Element Index: " + peakIndex);
        System.out.println("Peak Element Value: " + arr[peakIndex]);
        
        scanner.close();
    }
}
