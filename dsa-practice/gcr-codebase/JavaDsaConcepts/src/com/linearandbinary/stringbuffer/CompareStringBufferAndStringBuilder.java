package com.linearandbinary.stringbuffer;

import java.util.Scanner;

/**
 * Problem: Compare StringBuffer with StringBuilder for String Concatenation
 * Compares performance of both classes for large number of concatenations
 */
public class CompareStringBufferAndStringBuilder {
    
    public static long testStringBuffer(int iterations, String text) {
        long startTime = System.nanoTime();
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    public static long testStringBuilder(int iterations, String text) {
        long startTime = System.nanoTime();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Compare StringBuffer vs StringBuilder =====");
        System.out.print("Enter the text to concatenate: ");
        String text = scanner.nextLine();
        
        System.out.print("Enter number of iterations (e.g., 1000000): ");
        int iterations = scanner.nextInt();
        
        System.out.println("\nPerforming " + iterations + " concatenations...\n");
        
        // Test StringBuffer
        long bufferTime = testStringBuffer(iterations, text);
        System.out.println("StringBuffer Time: " + bufferTime + " nanoseconds");
        System.out.println("                   " + (bufferTime / 1_000_000) + " milliseconds");
        
        // Test StringBuilder
        long builderTime = testStringBuilder(iterations, text);
        System.out.println("\nStringBuilder Time: " + builderTime + " nanoseconds");
        System.out.println("                    " + (builderTime / 1_000_000) + " milliseconds");
        
        // Compare
        System.out.println("\n===== RESULT =====");
        if (builderTime < bufferTime) {
            System.out.println("StringBuilder is faster!");
            System.out.println("Difference: " + ((bufferTime - builderTime) / 1_000_000) + " ms");
        } else {
            System.out.println("StringBuffer is faster!");
            System.out.println("Difference: " + ((builderTime - bufferTime) / 1_000_000) + " ms");
        }
        
        scanner.close();
    }
}
