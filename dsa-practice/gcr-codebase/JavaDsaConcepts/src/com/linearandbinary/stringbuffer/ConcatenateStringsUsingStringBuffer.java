package com.linearandbinary.stringbuffer;

import java.util.Scanner;

/**
 * Problem: Concatenate Strings Efficiently Using StringBuffer
 * Uses StringBuffer to concatenate multiple strings efficiently
 */
public class ConcatenateStringsUsingStringBuffer {
    
    public static String concatenateStrings(String[] strings) {
        // Create StringBuffer object
        StringBuffer sb = new StringBuffer();
        
        // Iterate and append each string
        for (String str : strings) {
            sb.append(str);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Concatenate Strings Using StringBuffer =====");
        System.out.print("How many strings do you want to concatenate? ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        String[] strings = new String[n];
        
        System.out.println("\nEnter the strings:");
        for (int i = 0; i < n; i++) {
            System.out.print("String " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }
        
        String result = concatenateStrings(strings);
        
        System.out.println("\nConcatenated String: " + result);
        
        scanner.close();
    }
}
