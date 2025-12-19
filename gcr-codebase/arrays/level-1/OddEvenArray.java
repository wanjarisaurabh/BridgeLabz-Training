// Program to separate odd and even numbers
import java.util.Scanner;

public class OddEvenArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Invalid Input");
            return;
        }

        int[] odd = new int[number / 2 + 1];
        int[] even = new int[number / 2 + 1];
        int o = 0, e = 0;

        // Separating numbers into odd and even arrays
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[e++] = i;
            } else {
                odd[o++] = i;
            }
        }

        // Displaying odd numbers
        System.out.println("Odd Numbers:");
        for (int i = 0; i < o; i++) {
            System.out.print(odd[i] + " ");
        }

        // Displaying even numbers
        System.out.println("\nEven Numbers:");
        for (int i = 0; i < e; i++) {
            System.out.print(even[i] + " ");
        }

        input.close();
    }
}
