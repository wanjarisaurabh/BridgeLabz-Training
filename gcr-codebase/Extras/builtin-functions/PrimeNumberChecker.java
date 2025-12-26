
import java.util.Scanner;

/*
 * Program Name : PrimeNumberChecker
 *
 * Description :
 * A prime number is a number greater than 1 that has
 * no divisors other than 1 and itself.
 * This program checks whether a given number is prime
 * using a separate method.
 */
public class PrimeNumberChecker {

    // Checks if the given number is prime
    public static boolean isPrime(int number) {

        // Numbers less than or equal to 1 are not prime
        if (number <= 1) {
            return false;
        }

        // Check divisibility up to square root of the number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Display result
        if (isPrime(num)) {
            System.out.println("Prime Number");
        } else {
            System.out.println("Not a Prime Number");
        }

        sc.close();
    }
}
