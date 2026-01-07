package com.linearandbinary.filereader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Problem: Convert Byte Stream to Character Stream Using InputStreamReader
 * Reads binary data from file and prints as characters with specific encoding
 */
public class ConvertByteToCharacterStream {
    
    public static void readFileWithEncoding(String fileName, String encoding) {
        try {
            // Create FileInputStream for binary data
            FileInputStream fileInputStream = new FileInputStream(fileName);
            
            // Wrap in InputStreamReader with encoding
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, encoding);
            
            // Wrap in BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            String line;
            int lineNumber = 1;
            
            System.out.println("\n===== File Contents (Encoding: " + encoding + ") =====");
            
            // Read and print each line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
            
            // Close readers
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
            
            System.out.println("\nFile read successfully with " + encoding + " encoding.");
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Convert Byte Stream to Character Stream =====");
        System.out.print("Enter the file name (with path): ");
        String fileName = scanner.nextLine();
        
        System.out.print("Enter encoding (UTF-8, UTF-16, etc.) [Press Enter for UTF-8]: ");
        String encoding = scanner.nextLine();
        
        // Default to UTF-8 if no encoding specified
        if (encoding.trim().isEmpty()) {
            encoding = "UTF-8";
        }
        
        readFileWithEncoding(fileName, encoding);
        
        scanner.close();
    }
}
