import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Program Name : DateFormattingDemo
 * Description  : Displays the current date
 *                in three different formats.
 */
public class DateFormattingDemo {

    public static void main(String[] args) {

        // Get current date
        LocalDate today = LocalDate.now();

        // Define different date formats
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Display formatted dates
        System.out.println("Format dd/MM/yyyy       : " + today.format(format1));
        System.out.println("Format yyyy-MM-dd       : " + today.format(format2));
        System.out.println("Format EEE, MMM dd, yyyy: " + today.format(format3));
    }
}