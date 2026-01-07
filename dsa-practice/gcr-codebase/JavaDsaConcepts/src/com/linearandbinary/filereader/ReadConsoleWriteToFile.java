package com.linearandbinary.filereader;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem: Read User Input and Write to File Using InputStreamReader
 * Reads user input from console and writes to a file
 */
public class ReadConsoleWriteToFile {
    
    public static void main(String[] args) {
        System.out.println("===== Read User Input and Write to File =====");
        System.out.print("Enter the output file name: ");
        
        try {
            // Create InputStreamReader to read from console
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            // Read file name
            String fileName = bufferedReader.readLine();
            
            // Create FileWriter
            FileWriter fileWriter = new FileWriter(fileName);
            
            System.out.println("\nEnter text (type 'exit' to stop):");
            
            String line;
            int lineCount = 0;
            
            // Read and write lines
            while (true) {
                line = bufferedReader.readLine();
                
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                
                fileWriter.write(line + "\n");
                lineCount++;
            }
            
            // Close the writer
            fileWriter.close();
            
            System.out.println("\n✓ Successfully wrote " + lineCount + " line(s) to " + fileName);
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
