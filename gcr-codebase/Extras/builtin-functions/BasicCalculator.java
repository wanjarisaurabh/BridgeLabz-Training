
import java.util.Scanner;

/*
 * Program Name : BasicCalculator
 *
 * Description :
 * This program performs basic mathematical operations:
 * addition, subtraction, multiplication, and division.
 * Each operation is implemented using a separate method.
 */
public class BasicCalculator {

    // Adds two numbers
    public static double add(double a, double b) {
        return a + b;
    }

    // Subtracts second number from first
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplies two numbers
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Divides first number by second
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Division by zero is not allowed.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Display operations menu
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Choose operation: ");
        int choice = sc.nextInt();

        // Read input values
        System.out.print("Enter two numbers: ");
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();

        double result = 0;

        // Perform selected operation
        switch (choice) {
            case 1: result = add(num1, num2); break;
            case 2: result = subtract(num1, num2); break;
            case 3: result = multiply(num1, num2); break;
            case 4: result = divide(num1, num2); break;
            default:
                System.out.println("Invalid choice");
                sc.close();
                return;
        }

        // Display result
        System.out.println("Result: " + result);

        sc.close();
    }
}
