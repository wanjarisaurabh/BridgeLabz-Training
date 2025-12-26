
import java.util.Scanner;

/*
 * Program Name : GCDAndLCM
 *
 * Description :
 * This program calculates:
 * - Greatest Common Divisor (GCD)
 * - Least Common Multiple (LCM)
 * of two numbers using separate methods.
 */
public class GCDAndLCM {

    // Method to calculate GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Method to calculate LCM using GCD
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read two numbers
        System.out.print("Enter two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        // Display GCD and LCM
        System.out.println("GCD: " + gcd(num1, num2));
        System.out.println("LCM: " + lcm(num1, num2));

        sc.close();
    }
}
