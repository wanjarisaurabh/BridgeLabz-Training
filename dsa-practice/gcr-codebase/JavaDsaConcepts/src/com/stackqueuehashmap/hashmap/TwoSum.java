package com.stackqueuehashmap.hashmap;

import java.util.HashMap;

// Problem: Two Sum - return indices where values sum to target
// Store each number with its index, check if complement exists
public class Q5_TwoSum {

	public static void main(String[] args) {
		int[] arr1 = {2, 7, 11, 15};
		int target1 = 9;
		
		System.out.println("Array: ");
		for (int num : arr1) {
			System.out.print(num + " ");
		}
		System.out.println("\nTarget: " + target1);
		
		int[] result1 = twoSum(arr1, target1);
		printResult(arr1, result1, target1);
		
		System.out.println("\n--- Test Case 2 ---\n");
		
		int[] arr2 = {3, 2, 4};
		int target2 = 6;
		
		System.out.println("Array: ");
		for (int num : arr2) {
			System.out.print(num + " ");
		}
		System.out.println("\nTarget: " + target2);
		
		int[] result2 = twoSum(arr2, target2);
		printResult(arr2, result2, target2);
		
		System.out.println("\n--- Test Case 3 ---\n");
		
		int[] arr3 = {3, 3};
		int target3 = 6;
		
		System.out.println("Array: ");
		for (int num : arr3) {
			System.out.print(num + " ");
		}
		System.out.println("\nTarget: " + target3);
		
		int[] result3 = twoSum(arr3, target3);
		printResult(arr3, result3, target3);
		
		System.out.println("\n--- Test Case 4 (No solution) ---\n");
		
		int[] arr4 = {1, 2, 3};
		int target4 = 10;
		
		System.out.println("Array: ");
		for (int num : arr4) {
			System.out.print(num + " ");
		}
		System.out.println("\nTarget: " + target4);
		
		int[] result4 = twoSum(arr4, target4);
		printResult(arr4, result4, target4);
	}
	
	public static int[] twoSum(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			int currentNumber = arr[i];
			int complement = target - currentNumber;
			
			if (map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
			
			map.put(currentNumber, i);
		}
		
		return new int[] {-1, -1};
	}
	
	// Brute force approach - O(n²)
	public static int[] twoSumBruteForce(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		
		return new int[] {-1, -1};
	}
	
	public static void printResult(int[] arr, int[] result, int target) {
		if (result[0] == -1) {
			System.out.println("✗ No solution found!");
		} else {
			System.out.println("✓ Solution found!");
			System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
			System.out.println("Values: arr[" + result[0] + "] = " + arr[result[0]] + 
					", arr[" + result[1] + "] = " + arr[result[1]]);
			System.out.println("Sum: " + arr[result[0]] + " + " + arr[result[1]] + 
					" = " + (arr[result[0]] + arr[result[1]]));
		}
	}
}
