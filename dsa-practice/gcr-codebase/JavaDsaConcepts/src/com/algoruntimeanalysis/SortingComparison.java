package com.algoruntimeanalysis;

import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    
    public static void main(String[] args) {
        
        int[] sizes = {1000, 10000, 100000};
        
        System.out.println("=== Sorting Algorithm Comparison ===\n");
        
        for(int size : sizes) {
            int[] arr = new int[size];
            Random rand = new Random();
            for(int i=0; i<size; i++) {
                arr[i] = rand.nextInt(10000);
            }
            
            // Bubble Sort
            int[] arr1 = arr.clone();
            long start = System.nanoTime();
            bubbleSort(arr1);
            long end = System.nanoTime();
            double bubbleTime = (end - start) / 1000000.0;
            
            // Merge Sort
            int[] arr2 = arr.clone();
            start = System.nanoTime();
            mergeSort(arr2, 0, arr2.length - 1);
            end = System.nanoTime();
            double mergeTime = (end - start) / 1000000.0;
            
            // Quick Sort
            int[] arr3 = arr.clone();
            start = System.nanoTime();
            quickSort(arr3, 0, arr3.length - 1);
            end = System.nanoTime();
            double quickTime = (end - start) / 1000000.0;
            
            System.out.println("Dataset Size: " + size);
            System.out.println("Bubble Sort: " + bubbleTime + " ms");
            System.out.println("Merge Sort: " + mergeTime + " ms");
            System.out.println("Quick Sort: " + quickTime + " ms");
            System.out.println();
        }
    }
    
    // Bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    // Merge sort
    public static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for(int i=0; i<n1; i++) {
            L[i] = arr[left + i];
        }
        for(int j=0; j<n2; j++) {
            R[j] = arr[mid + 1 + j];
        }
        
        int i = 0, j = 0;
        int k = left;
        
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    // Quick sort
    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for(int j=low; j<high; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
}
