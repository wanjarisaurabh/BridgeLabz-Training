package com.linearandbinary.linearsearch;

import java.util.Scanner;

/**
 * Problem: Search for a Specific Word in a List of Sentences using Linear Search
 * Returns the first sentence containing the target word
 */
public class SearchWordInSentences {
    
    public static String findSentenceWithWord(String[] sentences, String targetWord) {
        // Iterate through sentences
        for (String sentence : sentences) {
            // Check if sentence contains the word (case-insensitive)
            if (sentence.toLowerCase().contains(targetWord.toLowerCase())) {
                return sentence;
            }
        }
        
        // Word not found
        return "Not Found";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Linear Search: Find Word in Sentences =====");
        System.out.print("Enter number of sentences: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        String[] sentences = new String[n];
        
        System.out.println("\nEnter " + n + " sentences:");
        for (int i = 0; i < n; i++) {
            System.out.print("Sentence " + (i + 1) + ": ");
            sentences[i] = scanner.nextLine();
        }
        
        System.out.print("\nEnter the word to search: ");
        String targetWord = scanner.nextLine();
        
        // Display all sentences
        System.out.println("\nAll Sentences:");
        for (int i = 0; i < sentences.length; i++) {
            System.out.println((i + 1) + ". " + sentences[i]);
        }
        
        // Search for word
        String result = findSentenceWithWord(sentences, targetWord);
        
        System.out.println("\n===== RESULT =====");
        if (!result.equals("Not Found")) {
            System.out.println("✓ Word \"" + targetWord + "\" found in:");
            System.out.println("  \"" + result + "\"");
        } else {
            System.out.println("✗ Word \"" + targetWord + "\" not found in any sentence.");
        }
        
        scanner.close();
    }
}
