
import java.util.Scanner;

/*
 * Program Name : MaximumOfThreeNumbers
 *
 * Description :
 * This program takes three integer inputs from the user
 * and determines the maximum value among them using
 * a separate utility method.
 */
public class MaximumOfThreeNumbers {

    // Returns the maximum of three integers
    public static int findMaximum(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read three integers from user
        System.out.print("Enter three numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        // Display maximum value
        int max = findMaximum(num1, num2, num3);
        System.out.println("Maximum number is: " + max);

        sc.close();
    }
}
