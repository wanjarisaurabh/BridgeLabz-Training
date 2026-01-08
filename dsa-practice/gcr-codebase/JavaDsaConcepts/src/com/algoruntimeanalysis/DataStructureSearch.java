package com.algoruntimeanalysis;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Random;

public class DataStructureSearch {
    
    public static void main(String[] args) {
        
        int[] sizes = {1000, 100000, 1000000};
        
        System.out.println("=== Data Structure Search Comparison ===\n");
        
        for(int size : sizes) {
            
            // Prepare data
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            
            Random rand = new Random();
            for(int i=0; i<size; i++) {
                int value = rand.nextInt(size * 10);
                array[i] = value;
                hashSet.add(value);
                treeSet.add(value);
            }
            
            int target = array[size - 1];
            
            // Array search
            long start = System.nanoTime();
            boolean found1 = searchInArray(array, target);
            long end = System.nanoTime();
            double arrayTime = (end - start) / 1000000.0;
            
            // HashSet search
            start = System.nanoTime();
            boolean found2 = hashSet.contains(target);
            end = System.nanoTime();
            double hashTime = (end - start) / 1000000.0;
            
            // TreeSet search
            start = System.nanoTime();
            boolean found3 = treeSet.contains(target);
            end = System.nanoTime();
            double treeTime = (end - start) / 1000000.0;
            
            System.out.println("Dataset Size: " + size);
            System.out.println("Array Search: " + arrayTime + " ms");
            System.out.println("HashSet Search: " + hashTime + " ms");
            System.out.println("TreeSet Search: " + treeTime + " ms");
            System.out.println();
        }
    }
    
    // Linear search in array
    public static boolean searchInArray(int[] arr, int target) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) {
                return true;
            }
        }
        return false;
    }
}
