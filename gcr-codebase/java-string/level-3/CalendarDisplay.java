
import java.util.Scanner;

/*
 * Program Name : CalendarDisplay
 * Description  : Displays calendar for a given month and year
 *                using Gregorian calendar algorithm.
 */
public class CalendarDisplay {
    // Method to check leap year
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    // Method to get first day of the month
    public static int getFirstDay(int month, int year) {

        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + (31 * m0) / 12) % 7;

        return d0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            days[1] = 29;
        }
        System.out.println("\n" + months[month - 1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getFirstDay(month, year);

        // Indentation
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print days
        for (int day = 1; day <= days[month - 1]; day++) {
            System.out.printf("%3d ", day);

            if ((day + startDay) % 7 == 0) {
                System.out.println();
            }
        }

        sc.close();
    }
}
