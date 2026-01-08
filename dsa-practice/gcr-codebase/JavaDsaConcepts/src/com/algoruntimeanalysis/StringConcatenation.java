package com.algoruntimeanalysis;

public class StringConcatenation {
    
    public static void main(String[] args) {
        
        int[] sizes = {1000, 10000, 100000};
        
        System.out.println("=== String Concatenation Comparison ===\n");
        
        for(int size : sizes) {
            
            // Using String
            long start = System.nanoTime();
            String str = "";
            for(int i=0; i<size; i++) {
                str += "hello";
            }
            long end = System.nanoTime();
            double stringTime = (end - start) / 1000000.0;
            
            // Using StringBuilder
            start = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<size; i++) {
                sb.append("hello");
            }
            String result1 = sb.toString();
            end = System.nanoTime();
            double sbTime = (end - start) / 1000000.0;
            
            // Using StringBuffer
            start = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for(int i=0; i<size; i++) {
                sbf.append("hello");
            }
            String result2 = sbf.toString();
            end = System.nanoTime();
            double sbfTime = (end - start) / 1000000.0;
            
            System.out.println("Operations Count: " + size);
            System.out.println("String: " + stringTime + " ms");
            System.out.println("StringBuilder: " + sbTime + " ms");
            System.out.println("StringBuffer: " + sbfTime + " ms");
            System.out.println();
        }
    }
}
