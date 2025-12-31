import java.util.Scanner;

/*
 * Program Name : LibraryFineCalculator
 * Description  : Calculates late return fines for books.
 *                Fine is ₹5 per day if returned late.
 *                Runs for 5 books using a for-loop.
 */

public class LibraryFineCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int finePerDay = 5;

        for (int book = 1; book <= 5; book++) {

            System.out.println("\nBook " + book + ":");

            System.out.print("Enter due date (day number): ");
            int dueDate = scanner.nextInt();

            System.out.print("Enter return date (day number): ");
            int returnDate = scanner.nextInt();

            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fine = lateDays * finePerDay;

                System.out.println("Late by " + lateDays + " days");
                System.out.println("Fine Amount: ₹" + fine);
            } else {
                System.out.println("Returned on time. No fine 😊");
            }
        }

        scanner.close();
        System.out.println("\nAll book records processed.");
    }
}
