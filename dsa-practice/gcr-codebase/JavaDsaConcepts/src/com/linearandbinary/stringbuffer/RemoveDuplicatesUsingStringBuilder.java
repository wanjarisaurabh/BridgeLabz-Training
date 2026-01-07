package com.linearandbinary.stringbuffer;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Problem: Remove Duplicates from a String Using StringBuilder
 * Removes duplicate characters while maintaining original order
 */
public class RemoveDuplicatesUsingStringBuilder {
    
    public static String removeDuplicates(String input) {
        // Initialize StringBuilder and HashSet
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        
        // Iterate through each character
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            // If character not seen before, add it
            if (!seen.contains(currentChar)) {
                sb.append(currentChar);
                seen.add(currentChar);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Remove Duplicates Using StringBuilder =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String result = removeDuplicates(input);
        
        System.out.println("\nOriginal String: " + input);
        System.out.println("After Removing Duplicates: " + result);
        
        scanner.close();
    }
}
