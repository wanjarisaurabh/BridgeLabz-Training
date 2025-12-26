import java.util.Scanner;

public class NumberCheckerQ6 {

    // Sum of proper divisors
    public static int sumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0)
                sum += i;
        }
        return sum;
    }

    // Perfect number check
    public static boolean isPerfect(int number) {
        return sumOfProperDivisors(number) == number;
    }

    // Abundant number check
    public static boolean isAbundant(int number) {
        return sumOfProperDivisors(number) > number;
    }

    // Deficient number check
    public static boolean isDeficient(int number) {
        return sumOfProperDivisors(number) < number;
    }

    // Factorial
    public static int factorial(int digit) {
        int fact = 1;
        for (int i = 1; i <= digit; i++)
            fact *= i;
        return fact;
    }

    // Store digits
    public static int[] storeDigits(int number) {
        int temp = number, count = 0;
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // Strong number check
    public static boolean isStrong(int number, int[] digits) {
        int sum = 0;
        for (int d : digits)
            sum += factorial(d);
        return sum == number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("Perfect Number: " + isPerfect(number));
        System.out.println("Abundant Number: " + isAbundant(number));
        System.out.println("Deficient Number: " + isDeficient(number));
        System.out.println("Strong Number: " + isStrong(number, digits));

        sc.close();
    }
}
