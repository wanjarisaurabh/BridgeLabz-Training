
import java.util.Scanner;
import java.util.Random;

/*
 * Program Name : NumberGuessingGame
 *
 * Description :
 * In this program, the user thinks of a number between 1 and 100.
 * The computer tries to guess the number by generating random guesses.
 * The user provides feedback as:
 *  - high     -> if the guess is higher than the number
 *  - low      -> if the guess is lower than the number
 *  - correct  -> if the guess is correct
 *
 * Based on the feedback, the range is adjusted until the correct
 * number is guessed.
 */
public class NumberGuessingGame {

    // Generates a random number between min and max (inclusive)
    public static int generateGuess(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initial guessing range
        int min = 1;
        int max = 100;

        System.out.println("Think of a number between 1 and 100.");

        // Loop continues until the correct guess is made
        while (true) {
            int guess = generateGuess(min, max);
            System.out.println("Computer guessed: " + guess);

            // Take feedback from the user
            System.out.print("Enter feedback (high / low / correct): ");
            String feedback = sc.next();

            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Computer guessed the number correctly!");
                break;
            } else if (feedback.equalsIgnoreCase("high")) {
                max = guess - 1; // Reduce upper limit
            } else if (feedback.equalsIgnoreCase("low")) {
                min = guess + 1; // Increase lower limit
            }
        }

        sc.close();
    }
}
