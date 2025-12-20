import java.util.Scanner;

public class LargestSecondLargestDigitDynamic {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Initial array size
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Loop to extract digits
        while (number != 0) {

            // If array is full, increase size by 10
            if (index == maxDigit) {
                maxDigit = maxDigit + 10;
                int[] temp = new int[maxDigit];

                // Copy existing digits to temp array
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                // Assign temp array to digits
                digits = temp;
            }

            // Store last digit
            digits[index] = number % 10;
            index++;

            // Remove last digit
            number = number / 10;
        }

        // Variables to store largest and second largest
        int
