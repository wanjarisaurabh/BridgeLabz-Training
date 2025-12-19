// Program to calculate mean height of players
import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0;

        // Calculating total height
        for (int i = 0; i < heights.length; i++) {
            heights[i] = input.nextDouble();
            sum += heights[i];
        }

        // Calculating and displaying mean height
        double mean = sum / 11;
        System.out.println("Mean Height = " + mean);

        input.close();
    }
}
