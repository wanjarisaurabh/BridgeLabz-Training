// Program to display multiplication table from 6 to 9
import java.util.Scanner;

public class TableSixToNine {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] result = new int[4];
        int index = 0;

        // Generating table values from 6 to 9
        for (int i = 6; i <= 9; i++) {
            result[index] = number * i;
            System.out.println(number + " * " + i + " = " + result[index]);
            index++;
        }

        input.close();
    }
}
