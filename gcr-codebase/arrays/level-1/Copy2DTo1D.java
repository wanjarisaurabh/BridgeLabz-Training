// Program to copy 2D array into 1D array
import java.util.Scanner;

public class Copy2DTo1D {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int rows = input.nextInt();
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];
        int[] array = new int[rows * cols];
        int index = 0;

        // Copying elements from 2D array to 1D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
                array[index++] = matrix[i][j];
            }
        }

        // Displaying 1D array elements
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        input.close();
    }
}
