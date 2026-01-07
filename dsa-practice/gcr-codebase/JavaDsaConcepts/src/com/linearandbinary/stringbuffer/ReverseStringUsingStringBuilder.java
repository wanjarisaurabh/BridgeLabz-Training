package com.linearandbinary.stringbuffer;

import java.util.Scanner;

/**
 * Problem: Reverse a String Using StringBuilder
 * Uses StringBuilder's reverse() method to reverse a given string
 */
public class ReverseStringUsingStringBuilder {
    
    public static String reverseString(String input) {
        // Create StringBuilder object
        StringBuilder sb = new StringBuilder(input);
        
        // Use reverse() method
        sb.reverse();
        
        // Convert back to String and return
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Reverse String Using StringBuilder =====");
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();
        
        String reversed = reverseString(input);
        
        System.out.println("\nOriginal String: " + input);
        System.out.println("Reversed String: " + reversed);
        
        scanner.close();
    }
}
