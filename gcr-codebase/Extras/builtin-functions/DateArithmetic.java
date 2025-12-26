import java.time.LocalDate;
import java.util.Scanner;

/*
 * Program Name : DateArithmetic
 * Description  : Takes a date input from the user,
 *                adds 7 days, 1 month, and 2 years,
 *                then subtracts 3 weeks from the result.
 */
public class DateArithmetic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take date input from user in yyyy-MM-dd format
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String inputDate = sc.nextLine();

        // Convert String input to LocalDate
        LocalDate date = LocalDate.parse(inputDate);

        // Perform date arithmetic operations
        LocalDate updatedDate = date
                .plusDays(7)
                .plusMonths(1)
                .plusYears(2)
                .minusWeeks(3);

        // Display the final date
        System.out.println("Final Date after calculations: " + updatedDate);

        sc.close();
    }
}