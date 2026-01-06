package com.stackqueuehashmap.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

// Problem: Find All Subarrays with Zero Sum
// Use cumulative sum with HashMap - if sum repeats, zero-sum subarray exists
public class Q1_ZeroSumSubarrays {

	public static void main(String[] args) {
		int[] arr = {4, 2, -3, 1, 6};
		
		System.out.println("Array: ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println("\n");
		
		findZeroSumSubarrays(arr);
		
		System.out.println("\n--- Another Example ---\n");
		
		int[] arr2 = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
		System.out.println("Array: ");
		for (int num : arr2) {
			System.out.print(num + " ");
		}
		System.out.println("\n");
		
		findZeroSumSubarrays(arr2);
	}
	
	public static void findZeroSumSubarrays(int[] arr) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		int sum = 0;
		boolean found = false;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
			if (sum == 0) {
				System.out.println("Subarray with zero sum found from index 0 to " + i);
				printSubarray(arr, 0, i);
				found = true;
			}
			
			if (map.containsKey(sum)) {
				ArrayList<Integer> list = map.get(sum);
				
				for (int startIndex : list) {
					System.out.println("Subarray with zero sum found from index " + 
							(startIndex + 1) + " to " + i);
					printSubarray(arr, startIndex + 1, i);
					found = true;
				}
			}
			
			if (!map.containsKey(sum)) {
				map.put(sum, new ArrayList<>());
			}
			map.get(sum).add(i);
		}
		
		if (!found) {
			System.out.println("No subarray with zero sum found!");
		}
	}
	
	public static void printSubarray(int[] arr, int start, int end) {
		System.out.print("Elements: [");
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i]);
			if (i < end) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
