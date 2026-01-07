package com.linearandbinary.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Problem: Read a File Line by Line Using FileReader
 * Reads and displays each line from a text file
 */
public class ReadFileLineByLine {
    
    public static void readFile(String fileName) {
        try {
            // Create FileReader and wrap in BufferedReader
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            int lineNumber = 1;
            
            System.out.println("\n===== File Contents =====");
            
            // Read line by line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
            
            // Close the reader
            bufferedReader.close();
            fileReader.close();
            
            System.out.println("\nTotal lines read: " + (lineNumber - 1));
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            System.out.println("Make sure the file exists in the correct location.");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Read File Line by Line =====");
        System.out.print("Enter the file name (with path): ");
        String fileName = scanner.nextLine();
        
        readFile(fileName);
        
        scanner.close();
    }
}
