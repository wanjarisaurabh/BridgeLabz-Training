
import java.util.Scanner;

/*
 * Program Name : NumberGuessingGame
 * Description  : Guess the number within 5 attempts
 */
public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = (int) (Math.random() * 100) + 1;
        int attempts = 0;

        do {
            System.out.print("Guess the number: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess > number) {
                System.out.println("Too high!");
            } else if (guess < number) {
                System.out.println("Too low!");
            } else {
                System.out.println("Correct! You won.");
                return;
            }
        } while (attempts < 5);

        System.out.println("Game Over! Number was: " + number);
    }
}
