// Program to store numbers and calculate sum
import java.util.Scanner;

public class StoreNumbers {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0;
        int index = 0;

        // Accepting numbers until stop condition is met
        while (true) {
            double value = input.nextDouble();
            if (value <= 0 || index == 10) {
                break;
            }
            numbers[index++] = value;
        }

        // Calculating sum of stored numbers
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Displaying final sum
        System.out.println("Total Sum = " + total);

        input.close();
    }
}
