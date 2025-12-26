import java.time.LocalDate;
import java.util.Scanner;

/*
 * Program Name : DateComparison
 * Description  : Compares two dates entered by the user
 *                and checks whether the first date is
 *                before, after, or equal to the second date.
 */
public class DateComparison {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take first date input
        System.out.print("Enter first date (yyyy-MM-dd): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine());

        // Take second date input
        System.out.print("Enter second date (yyyy-MM-dd): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine());

        // Compare the dates
        if (date1.isBefore(date2)) {
            System.out.println("First date is BEFORE the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is AFTER the second date.");
        } else {
            System.out.println("Both dates are the SAME.");
        }

        sc.close();
    }
}