package com.algoruntimeanalysis;

import java.io.*;

public class FileReadingComparison {
    
    public static void main(String[] args) {
        
        String[] fileSizes = {"1MB", "10MB", "50MB"};
        int[] dataSizes = {1000000, 10000000, 50000000};
        
        System.out.println("=== File Reading Comparison ===\n");
        
        for(int i=0; i<fileSizes.length; i++) {
            String fileName = "testfile_" + fileSizes[i] + ".txt";
            
            // Create test file
            createTestFile(fileName, dataSizes[i]);
            
            // FileReader test
            long start = System.nanoTime();
            readWithFileReader(fileName);
            long end = System.nanoTime();
            double fileReaderTime = (end - start) / 1000000.0;
            
            // InputStreamReader test
            start = System.nanoTime();
            readWithInputStreamReader(fileName);
            end = System.nanoTime();
            double inputStreamTime = (end - start) / 1000000.0;
            
            System.out.println("File Size: " + fileSizes[i]);
            System.out.println("FileReader: " + fileReaderTime + " ms");
            System.out.println("InputStreamReader: " + inputStreamTime + " ms");
            System.out.println();
            
            // Delete test file
            new File(fileName).delete();
        }
    }
    
    // Create test file with data
    public static void createTestFile(String fileName, int size) {
        try {
            FileWriter fw = new FileWriter(fileName);
            for(int i=0; i<size; i++) {
                fw.write("A");
            }
            fw.close();
        } catch(IOException e) {
            System.out.println("Error creating file");
        }
    }
    
    // Read using FileReader
    public static void readWithFileReader(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            while(fr.read() != -1) {
                // just reading
            }
            fr.close();
        } catch(IOException e) {
            System.out.println("Error reading file");
        }
    }
    
    // Read using InputStreamReader
    public static void readWithInputStreamReader(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            while(isr.read() != -1) {
                // just reading
            }
            isr.close();
            fis.close();
        } catch(IOException e) {
            System.out.println("Error reading file");
        }
    }
}
