import java.time.ZoneId;
import java.time.ZonedDateTime;

/*
 * Program Name : TimeZonesDemo
 * Description  : Displays the current date and time
 *                in different time zones using ZonedDateTime.
 */
public class TimeZonesDemo {

    public static void main(String[] args) {

        // Get current date and time in GMT
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));

        // Get current date and time in IST
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

        // Get current date and time in PST
        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        // Display the results
        System.out.println("Current Time in GMT : " + gmtTime);
        System.out.println("Current Time in IST : " + istTime);
        System.out.println("Current Time in PST : " + pstTime);
    }
}