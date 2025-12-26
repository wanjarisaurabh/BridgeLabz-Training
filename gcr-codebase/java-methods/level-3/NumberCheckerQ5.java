import java.util.Scanner;

public class NumberCheckerQ5 {

    // Prime number check
    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    // Neon number check
    public static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;

        while (square != 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
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

    // Spy number check
    public static boolean isSpy(int[] digits) {
        int sum = 0, product = 1;

        for (int d : digits) {
            sum += d;
            product *= d;
        }
        return sum == product;
    }

    // Automorphic number check
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    // Buzz number check
    public static boolean isBuzz(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("Prime Number: " + isPrime(number));
        System.out.println("Neon Number: " + isNeon(number));
        System.out.println("Spy Number: " + isSpy(digits));
        System.out.println("Automorphic Number: " + isAutomorphic(number));
        System.out.println("Buzz Number: " + isBuzz(number));

        sc.close();
    }
}
