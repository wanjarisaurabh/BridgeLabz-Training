package com.stackqueuehashmap.hashmap;

import java.util.HashSet;

// Problem: Longest Consecutive Sequence
// Use HashSet, check if num-1 exists to find sequence start
public class Q3_LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] arr1 = {100, 4, 200, 1, 3, 2};
		
		System.out.println("Array: ");
		for (int num : arr1) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		int length1 = findLongestConsecutive(arr1);
		System.out.println("Length of longest consecutive sequence: " + length1);
		
		System.out.println("\n--- Test Case 2 ---\n");
		
		int[] arr2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		
		System.out.println("Array: ");
		for (int num : arr2) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		int length2 = findLongestConsecutive(arr2);
		System.out.println("Length of longest consecutive sequence: " + length2);
		
		System.out.println("\n--- Test Case 3 ---\n");
		
		int[] arr3 = {9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7};
		
		System.out.println("Array: ");
		for (int num : arr3) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		int length3 = findLongestConsecutive(arr3);
		System.out.println("Length of longest consecutive sequence: " + length3);
	}
	
	public static int findLongestConsecutive(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		HashSet<Integer> set = new HashSet<>();
		for (int num : arr) {
			set.add(num);
		}
		
		int longestStreak = 0;
		
		for (int num : set) {
			if (!set.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 1;
				
				while (set.contains(currentNum + 1)) {
					currentNum++;
					currentStreak++;
				}
				
				if (currentStreak > longestStreak) {
					longestStreak = currentStreak;
					System.out.print("Found sequence: ");
					for (int i = num; i <= currentNum; i++) {
						System.out.print(i + " ");
					}
					System.out.println("(length: " + currentStreak + ")");
				}
			}
		}
		
		return longestStreak;
	}
	
	// Brute force approach for comparison - O(n²)
	public static int findLongestConsecutiveBruteForce(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		int longestStreak = 1;
		
		// For each number, try to build a sequence
		for (int num : arr) {
			int currentNum = num;
			int currentStreak = 1;
			
			// Keep checking if next consecutive number exists
			while (arrayContains(arr, currentNum + 1)) {
				currentNum++;
				currentStreak++;
			}
			
			longestStreak = Math.max(longestStreak, currentStreak);
		}
		
		return longestStreak;
	}
	
	private static boolean arrayContains(int[] arr, int target) {
		for (int num : arr) {
			if (num == target) {
				return true;
			}
		}
		return false;
	}
}
