import java.util.Scanner;

/*
 * Program Name : MovieTicketBookingApp
 * Description  : Allows users to book movie tickets by selecting
 *                movie type, seat type, and snacks.
 *                The program supports multiple customers.
 */

public class MovieTicketBookingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean moreCustomers = true;

        while (moreCustomers) {

            int ticketPrice = 0;
            int snackPrice = 0;

            // Movie type input
            System.out.print("\nEnter movie type (bollywood / hollywood): ");
            String movieType = scanner.nextLine().toLowerCase();

            // Seat type input
            System.out.print("Enter seat type (gold / silver): ");
            String seatType = scanner.nextLine().toLowerCase();

            // Decide ticket price
            switch (movieType) {

                case "bollywood":
                    if (seatType.equals("gold")) {
                        ticketPrice = 250;
                    } else if (seatType.equals("silver")) {
                        ticketPrice = 150;
                    } else {
                        System.out.println("Invalid seat type!");
                        continue;
                    }
                    break;

                case "hollywood":
                    if (seatType.equals("gold")) {
                        ticketPrice = 350;
                    } else if (seatType.equals("silver")) {
                        ticketPrice = 250;
                    } else {
                        System.out.println("Invalid seat type!");
                        continue;
                    }
                    break;

                default:
                    System.out.println("Invalid movie type!");
                    continue;
            }

            // Snacks option
            System.out.print("Do you want snacks? (yes / no): ");
            String snacks = scanner.nextLine().toLowerCase();

            if (snacks.equals("yes")) {
                snackPrice = 100;
            }

            int totalBill = ticketPrice + snackPrice;

            // Display bill
            System.out.println("\n--- Booking Summary ---");
            System.out.println("Movie Type  : " + movieType);
            System.out.println("Seat Type   : " + seatType);
            System.out.println("Ticket Cost : ₹" + ticketPrice);
            System.out.println("Snack Cost  : ₹" + snackPrice);
            System.out.println("Total Bill  : ₹" + totalBill);

            // Continue or exit
            System.out.print("\nBook for next customer? (yes / no): ");
            String choice = scanner.nextLine().toLowerCase();

            if (!choice.equals("yes")) {
                moreCustomers = false;
                System.out.println("Thank you! Enjoy your movie 🎥");
            }
        }

        scanner.close();
    }
}
