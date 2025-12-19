// Program to generate multiplication table
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] table = new int[10];

        // Calculating multiplication values
        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }

        // Displaying multiplication table
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }

        input.close();
    }
}
