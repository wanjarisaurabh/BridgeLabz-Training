
import java.util.Scanner;

/*
 * Program Name : FibonacciSequence
 *
 * Description :
 * This program generates the Fibonacci sequence
 * up to a user-specified number of terms.
 * Fibonacci sequence starts with:
 * 0 1 1 2 3 5 ...
 */
public class FibonacciSequence {

    // Generates and prints Fibonacci sequence
    public static void generateFibonacci(int terms) {
        int first = 0;
        int second = 1;

        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of terms
        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();

        // Generate Fibonacci sequence
        generateFibonacci(terms);

        sc.close();
    }
}
