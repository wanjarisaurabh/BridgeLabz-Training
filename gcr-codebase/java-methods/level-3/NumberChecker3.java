
import java.util.Scanner;

public class NumberChecker3 {

    // Method to count digits in a number
    public static int countDigits(int number) {
        int count = 0;
        int temp = number;

        while (temp != 0) {
            count++;
            temp = temp / 10;
        }
        return count;
    }

    // Method to store digits in an array
    public static int[] storeDigits(int number, int count) {
        int[] digits = new int[count];
        int temp = number;

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }
        return digits;
    }

    // Method to find sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    // Method to find sum of squares of digits
    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    // Method to check Harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    // Method to find frequency of each digit using 2D array
    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];

        // Initialize first column with digits 0-9
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
            freq[i][1] = 0;
        }

        // Count frequency
        for (int d : digits) {
            freq[d][1]++;
        }
        return freq;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Count digits
        int count = countDigits(number);
        System.out.println("Number of digits: " + count);

        // Store digits
        int[] digits = storeDigits(number, count);

        // Display digits
        System.out.print("Digits Array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        // Sum of digits
        System.out.println("Sum of digits: " + sumOfDigits(digits));

        // Sum of squares of digits
        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(digits));

        // Harshad number check
        System.out.println("Is Harshad Number: " + isHarshadNumber(number, digits));

        // Digit frequency
        int[][] frequency = digitFrequency(digits);
        System.out.println("Digit Frequency:");
        System.out.println("Digit  Frequency");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println("  " + frequency[i][0] + "        " + frequency[i][1]);
            }
        }

        sc.close();
    }
}
