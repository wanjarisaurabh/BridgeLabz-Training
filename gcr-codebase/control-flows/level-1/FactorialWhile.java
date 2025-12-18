
import java.util.Scanner;

public class FactorialWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number >= 0) {
            int fact = 1;
            int i = 1;

            while (i <= number) {
                fact *= i;
                i++;
            }

            System.out.println("Factorial is " + fact);
        }
    }
}
