import java.util.Scanner;

/*
 * Program Name : TrainReservationQueue
 * Description  : Simulates a basic train ticket booking system
 *                with limited seats.
 */

public class TrainReservationQueue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int availableSeats = 10;

        while (true) {

            System.out.println("\n--- Train Reservation Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Show Available Seats");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    if (availableSeats == 0) {
                        System.out.println("No seats available. Booking closed.");
                        break;
                    }

                    System.out.print("Enter number of tickets to book: ");
                    int tickets = scanner.nextInt();

                    if (tickets <= availableSeats) {
                        availableSeats -= tickets;
                        System.out.println("Tickets booked successfully!");
                    } else {
                        System.out.println("Not enough seats available.");
                    }
                    break;

                case 2:
                    System.out.println("Available Seats: " + availableSeats);
                    break;

                case 3:
                    System.out.println("Thank you for using the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

            // Stop booking when seats are zero
            if (availableSeats == 0) {
                System.out.println("All seats are booked. Exiting system.");
                break;
            }
        }

        scanner.close();
    }
}
