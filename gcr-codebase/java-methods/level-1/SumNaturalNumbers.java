import java.util.Scanner;

public class SumNaturalNumbers {

    // Method to find sum using loop
    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Sum is: " + sumOfNaturalNumbers(n));
    }
}
