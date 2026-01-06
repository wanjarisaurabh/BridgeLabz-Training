package com.stackqueuehashmap.hashmap;

import java.util.HashMap;

// Problem: Check for a Pair with Given Sum
// Store visited numbers and check if (target - current) exists
public class Q2_PairWithGivenSum {

	public static void main(String[] args) {
		int[] arr1 = {8, 7, 2, 5, 3, 1};
		int target1 = 10;
		
		System.out.println("Array: ");
		for (int num : arr1) {
			System.out.print(num + " ");
		}
		System.out.println("\nTarget Sum: " + target1);
		
		findPairWithSum(arr1, target1);
		
		System.out.println("\n--- Test Case 2 ---\n");
		
		int[] arr2 = {1, 4, 45, 6, 10, 8};
		int target2 = 16;
		
		System.out.println("Array: ");
		for (int num : arr2) {
			System.out.print(num + " ");
		}
		System.out.println("\nTarget Sum: " + target2);
		
		findPairWithSum(arr2, target2);
		
		System.out.println("\n--- Test Case 3 (No pair exists) ---\n");
		
		int[] arr3 = {1, 2, 3, 4};
		int target3 = 10;
		
		System.out.println("Array: ");
		for (int num : arr3) {
			System.out.print(num + " ");
		}
		System.out.println("\nTarget Sum: " + target3);
		
		findPairWithSum(arr3, target3);
	}
	
	public static void findPairWithSum(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			int currentElement = arr[i];
			int complement = target - currentElement;
			
			if (map.containsKey(complement)) {
				System.out.println("✓ Pair found: (" + complement + ", " + currentElement + ")");
				System.out.println("  Index: " + map.get(complement) + " and " + i);
				return;
			}
			
			map.put(currentElement, i);
		}
		
		System.out.println("✗ No pair with sum " + target + " exists in the array");
	}
	
	// Alternative: Find ALL pairs with given sum
	public static void findAllPairsWithSum(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		boolean pairFound = false;
		
		System.out.println("\nFinding all pairs with sum " + target + ":");
		
		for (int i = 0; i < arr.length; i++) {
			int currentElement = arr[i];
			int complement = target - currentElement;
			
			if (map.containsKey(complement)) {
				System.out.println("Pair found: (" + complement + ", " + currentElement + ")");
				pairFound = true;
			}
			
			map.put(currentElement, i);
		}
		
		if (!pairFound) {
			System.out.println("No pairs found!");
		}
	}
}
