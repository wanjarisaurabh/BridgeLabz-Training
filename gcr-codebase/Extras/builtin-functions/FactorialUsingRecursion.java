
import java.util.Scanner;

/*
 * Program Name : FactorialUsingRecursion
 *
 * Description :
 * Factorial of a number n is:
 * n! = n × (n - 1) × (n - 2) × ... × 1
 * This program calculates factorial using recursion.
 */
public class FactorialUsingRecursion {

    // Recursive method to calculate factorial
    public static long factorial(int n) {

        // Base condition
        if (n == 0) {
            return 1;
        }

        // Recursive call
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Display factorial
        System.out.println("Factorial is: " + factorial(number));

        sc.close();
    }
}
