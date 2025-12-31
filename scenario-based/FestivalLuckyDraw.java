
import java.util.Scanner;

/*
 * Program: FestivalLuckyDraw
 * Description:
 * Visitor draws a number.
 * Wins if divisible by both 3 and 5.
 * Invalid input continues to next visitor.
 */
public class FestivalLuckyDraw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char moreVisitors = 'y';

        while (moreVisitors == 'y') {

            System.out.print("Enter your lucky number: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Try again.");
                sc.next(); // clear invalid input
                continue;
            }

            int number = sc.nextInt();

            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("🎁 Congratulations! You won a gift!");
            } else {
                System.out.println("Better luck next time!");
            }

            System.out.print("Next visitor? (y/n): ");
            moreVisitors = sc.next().toLowerCase().charAt(0);
        }
    }
}
