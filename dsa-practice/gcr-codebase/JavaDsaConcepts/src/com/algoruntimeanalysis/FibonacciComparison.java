package com.algoruntimeanalysis;

public class FibonacciComparison {
    
    public static void main(String[] args) {
        
        int[] values = {10, 20, 30, 40};
        
        System.out.println("=== Fibonacci Comparison ===\n");
        
        for(int n : values) {
            
            // Recursive approach
            long start = System.nanoTime();
            int resultRecursive = fibonacciRecursive(n);
            long end = System.nanoTime();
            double recursiveTime = (end - start) / 1000000.0;
            
            // Iterative approach
            start = System.nanoTime();
            int resultIterative = fibonacciIterative(n);
            end = System.nanoTime();
            double iterativeTime = (end - start) / 1000000.0;
            
            System.out.println("Fibonacci(" + n + ")");
            System.out.println("Recursive: " + recursiveTime + " ms");
            System.out.println("Iterative: " + iterativeTime + " ms");
            System.out.println("Result: " + resultIterative);
            System.out.println();
        }
    }
    
    // Recursive fibonacci
    public static int fibonacciRecursive(int n) {
        if(n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    // Iterative fibonacci
    public static int fibonacciIterative(int n) {
        if(n <= 1) {
            return n;
        }
        
        int a = 0;
        int b = 1;
        int sum = 0;
        
        for(int i=2; i<=n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        
        return b;
    }
}
