package com.sorting;

import java.util.Scanner;

public class Q4_QuickSortProductPrices {
    
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }
    
    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        
        return i + 1;
    }
    
    public static void printArray(double[] arr) {
        for (double price : arr) {
            System.out.printf("%.2f ", price);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        
        double[] productPrices = new double[n];
        
        System.out.println("Enter " + n + " product prices:");
        for (int i = 0; i < n; i++) {
            productPrices[i] = sc.nextDouble();
        }
        
        System.out.println("\nOriginal Product Prices:");
        printArray(productPrices);
        
        quickSort(productPrices, 0, productPrices.length - 1);
        
        System.out.println("\nSorted Product Prices (Ascending Order):");
        printArray(productPrices);
        
        sc.close();
    }
}
