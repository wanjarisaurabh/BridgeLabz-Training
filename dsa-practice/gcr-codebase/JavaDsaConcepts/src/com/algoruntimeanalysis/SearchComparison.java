package com.algoruntimeanalysis;

import java.util.Arrays;

public class SearchComparison {
    
    public static void main(String[] args) {
        
        int[] sizes = {1000, 10000, 1000000};
        
        System.out.println("=== Search Algorithm Comparison ===\n");
        
        for(int size : sizes) {
            int[] arr = new int[size];
            for(int i=0; i<size; i++) {
                arr[i] = i;
            }
            
            int target = size - 1;
            
            // Linear Search
            long start = System.nanoTime();
            linearSearch(arr, target);
            long end = System.nanoTime();
            double linearTime = (end - start) / 1000000.0;
            
            // Binary Search
            Arrays.sort(arr);
            start = System.nanoTime();
            binarySearch(arr, target);
            end = System.nanoTime();
            double binaryTime = (end - start) / 1000000.0;
            
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search: " + linearTime + " ms");
            System.out.println("Binary Search: " + binaryTime + " ms");
            System.out.println();
        }
    }
    
    // Simple linear search
    public static int linearSearch(int[] arr, int target) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    // Binary search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
