package com.linearandbinary.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Challenge Problem: Compare StringBuilder, StringBuffer, FileReader, and InputStreamReader
 * Tests performance of string concatenation and file reading
 */
public class ChallengeCompareAll {
    
    // Test StringBuilder concatenation
    public static long testStringBuilder(int iterations) {
        long startTime = System.nanoTime();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("hello");
        }
        
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    // Test StringBuffer concatenation
    public static long testStringBuffer(int iterations) {
        long startTime = System.nanoTime();
        
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("hello");
        }
        
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    
    // Count words using FileReader
    public static long countWordsWithFileReader(String fileName) {
        long wordCount = 0;
        long startTime = System.nanoTime();
        
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
            
            bufferedReader.close();
            fileReader.close();
            
        } catch (IOException e) {
            System.out.println("FileReader Error: " + e.getMessage());
        }
        
        long endTime = System.nanoTime();
        System.out.println("FileReader: " + wordCount + " words, Time: " + 
                          (endTime - startTime) / 1_000_000 + " ms");
        
        return endTime - startTime;
    }
    
    // Count words using InputStreamReader
    public static long countWordsWithInputStreamReader(String fileName) {
        long wordCount = 0;
        long startTime = System.nanoTime();
        
        try {
            java.io.FileInputStream fis = new java.io.FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }
            
            bufferedReader.close();
            inputStreamReader.close();
            fis.close();
            
        } catch (IOException e) {
            System.out.println("InputStreamReader Error: " + e.getMessage());
        }
        
        long endTime = System.nanoTime();
        System.out.println("InputStreamReader: " + wordCount + " words, Time: " + 
                          (endTime - startTime) / 1_000_000 + " ms");
        
        return endTime - startTime;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("  CHALLENGE: Compare All Components");
        System.out.println("========================================");
        
        // Part 1: String Concatenation
        System.out.println("\n===== PART 1: String Concatenation Test =====");
        System.out.print("Enter number of iterations (e.g., 1000000): ");
        int iterations = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("\nTesting with " + iterations + " concatenations...\n");
        
        long builderTime = testStringBuilder(iterations);
        System.out.println("StringBuilder Time: " + builderTime / 1_000_000 + " ms");
        
        long bufferTime = testStringBuffer(iterations);
        System.out.println("StringBuffer Time:  " + bufferTime / 1_000_000 + " ms");
        
        System.out.println("\nWinner: " + (builderTime < bufferTime ? "StringBuilder" : "StringBuffer"));
        
        // Part 2: File Reading
        System.out.println("\n===== PART 2: File Reading Test =====");
        System.out.print("Enter file name to analyze: ");
        String fileName = scanner.nextLine();
        
        System.out.println("\nCounting words in file...\n");
        
        long fileReaderTime = countWordsWithFileReader(fileName);
        long inputStreamReaderTime = countWordsWithInputStreamReader(fileName);
        
        System.out.println("\nWinner: " + 
            (fileReaderTime < inputStreamReaderTime ? "FileReader" : "InputStreamReader"));
        
        System.out.println("\n===== TEST COMPLETE =====");
        
        scanner.close();
    }
}
