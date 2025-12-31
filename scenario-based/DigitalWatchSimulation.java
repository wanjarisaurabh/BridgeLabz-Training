/*
 * Program: DigitalWatchSimulation
 * Description:
 * Simulates a 24-hour digital watch.
 * Prints hours and minutes using nested loops.
 * Stops manually at 13:00 to simulate a power cut.
 */

public class DigitalWatchSimulation {

    public static void main(String[] args) {

        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute++) {

                // Stop at 13:00
                if (hour == 13 && minute == 0) {
                    System.out.println("⚡ Power Cut at 13:00");
                    break;
                }

                // Format HH:MM
                System.out.printf("%02d:%02d%n", hour, minute);
            }

            // Break outer loop as well
            if (hour == 13) {
                break;
            }
        }
    }
}
