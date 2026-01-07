package com.linearandbinary.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Problem: Count the Occurrence of a Word in a File Using FileReader
 * Counts how many times a specific word appears in a file
 */
public class CountWordOccurrenceInFile {
    
    public static int countWord(String fileName, String targetWord) {
        int count = 0;
        
        try {
            // Create FileReader and wrap in BufferedReader
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            
            // Read each line
            while ((line = bufferedReader.readLine()) != null) {
                // Split line into words
                String[] words = line.split("\\s+");
                
                // Check each word
                for (String word : words) {
                    // Remove punctuation and compare (case-insensitive)
                    String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
                    if (cleanWord.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            
            // Close the reader
            bufferedReader.close();
            fileReader.close();
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Count Word Occurrence in File =====");
        System.out.print("Enter the file name (with path): ");
        String fileName = scanner.nextLine();
        
        System.out.print("Enter the word to search: ");
        String targetWord = scanner.nextLine();
        
        int count = countWord(fileName, targetWord);
        
        System.out.println("\nThe word \"" + targetWord + "\" appears " + count + " time(s) in the file.");
        
        scanner.close();
    }
}
