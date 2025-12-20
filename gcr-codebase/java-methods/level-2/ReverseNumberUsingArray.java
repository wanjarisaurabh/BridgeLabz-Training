import java.util.Scanner;

public class ReverseNumberUsingArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;

        // Step 1: Find count of digits
        int count = 0;
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        // Step 2: Create array to store digits
        int[] digits = new int[count];
        temp = number;

        // Step 3: Store digits in array
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }

        // Step 4: Create reverse array
        int[] reverse = new int[count];
        for (int i = 0; i < count; i++) {
            reverse[i] = digits[count - 1 - i];
        }

        // Step 5: Display reversed number
        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reverse[i]);
        }

        sc.close();
    }
}
