import java.util.Scanner;

public class NumberChecker2 {

    // Method to find count of digits in a number
    public static int countDigits(int number) {
        int count = 0;
        int temp = number;

        while (temp != 0) {
            count++;
            temp = temp / 10;
        }
        return count;
    }

    // Method to store digits of the number into an array
    public static int[] getDigitsArray(int number, int count) {
        int[] digits = new int[count];
        int temp = number;

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }
        return digits;
    }

    // Method to check Duck Number
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }

    // Method to check Armstrong Number
    public static boolean isArmstrongNumber(int number, int[] digits) {
        int sum = 0;
        int power = digits.length;

        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }

    // Method to find largest and second largest digit
    public static void findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }

        System.out.println("Largest Digit: " + largest);
        System.out.println("Second Largest Digit: " + secondLargest);
    }

    // Method to find smallest and second smallest digit
    public static void findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }

        System.out.println("Smallest Digit: " + smallest);
        System.out.println("Second Smallest Digit: " + secondSmallest);
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Counting digits
        int count = countDigits(number);
        System.out.println("Number of digits: " + count);

        // Creating digits array
        int[] digits = getDigitsArray(number, count);

        // Display digits
        System.out.print("Digits Array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        // Duck number check
        System.out.println("Is Duck Number: " + isDuckNumber(digits));

        // Armstrong number check
        System.out.println("Is Armstrong Number: " + isArmstrongNumber(number, digits));

        // Largest & second largest digit
        findLargestAndSecondLargest(digits);

        // Smallest & second smallest digit
        findSmallestAndSecondSmallest(digits);

        sc.close();
    }
}
