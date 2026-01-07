package com.linearandbinary.binarysearch;

import java.util.Scanner;

/**
 * Problem: Search for a Target Value in a 2D Sorted Matrix using Binary Search
 * Matrix rows are sorted, and first element of each row > last element of previous row
 */
public class SearchIn2DMatrix {
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Treat matrix as 1D array
        int left = 0;
        int right = rows * cols - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Convert mid to row and column
            int row = mid / cols;
            int col = mid % cols;
            
            int midValue = matrix[row][col];
            
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Binary Search: Search in 2D Matrix =====");
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();
        
        int[][] matrix = new int[rows][cols];
        
        System.out.println("\nEnter matrix elements (sorted):");
        for (int i = 0; i < rows; i++) {
            System.out.println("Row " + (i + 1) + ":");
            for (int j = 0; j < cols; j++) {
                System.out.print("  Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        // Display matrix
        System.out.println("\nMatrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        
        System.out.print("\nEnter target value to search: ");
        int target = scanner.nextInt();
        
        // Search
        boolean found = searchMatrix(matrix, target);
        
        System.out.println("\n===== RESULT =====");
        if (found) {
            System.out.println("✓ Target " + target + " found in matrix!");
        } else {
            System.out.println("✗ Target " + target + " not found in matrix.");
        }
        
        scanner.close();
    }
}
