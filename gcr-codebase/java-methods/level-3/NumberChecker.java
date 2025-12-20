
import java.util.Scanner;

public class NumberChecker {

    // a. Method to count digits
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number = number / 10;
        }
        return count;
    }

    // a. Method to store digits in an array
    public static int[] storeDigits(int number, int count) {
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number = number / 10;
        }
        return digits;
    }

    // b. Method to reverse the digits array
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        int j = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            reversed[j++] = digits[i];
        }
        return reversed;
    }

    // c. Method to compare two arrays
    public static boolean compareArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    // d. Method to check palindrome using digits
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseDigits(digits);
        return compareArrays(digits, reversed);
    }

    // e. Method to check Duck number using digits array
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) {
                return true;
            }
        }
        return false;
    }

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int count = countDigits(number);
        int[] digits = storeDigits(number, count);

        System.out.print("Digits Array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        System.out.println("Palindrome Number: " + isPalindrome(digits));
        System.out.println("Duck Number: " + isDuckNumber(digits));

        sc.close();
    }
}
