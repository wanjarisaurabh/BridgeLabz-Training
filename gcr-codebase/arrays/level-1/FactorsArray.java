// Program to find factors of a number
import java.util.Scanner;

public class FactorsArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int size = 10;
        int[] factors = new int[size];
        int index = 0;

        // Finding factors of the number
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {

                if (index == size) {
                    size *= 2;
                    int[] temp = new int[size];
                    for (int j = 0; j < factors.length; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }

                factors[index++] = i;
            }
        }

        // Displaying all factors
        System.out.println("Factors:");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }

        input.close();
    }
}
