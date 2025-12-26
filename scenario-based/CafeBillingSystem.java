import java.util.Scanner;

/*
 * Program Name : CafeBillingSystem
 * Description  : This program allows customers to order coffee,
 *                calculates the total bill with GST, and continues
 *                serving customers until the user types "exit".
 */
public class CafeBillingSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final double GST_RATE = 0.05; // 5% GST
        boolean isRunning = true;

        // Continue serving customers until user types "exit"
        while (isRunning) {

            System.out.print("\nEnter coffee type (espresso/latte/cappuccino) or 'exit' to stop: ");
            String coffeeType = scanner.next().toLowerCase();

            // Check exit condition
            if (coffeeType.equals("exit")) {
                System.out.println("Thank you for visiting Ravi's Café!");
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            double pricePerCup = 0.0;

            // Decide coffee price using switch
            switch (coffeeType) {
                case "espresso":
                    pricePerCup = 100;
                    break;
                case "latte":
                    pricePerCup = 150;
                    break;
                case "cappuccino":
                    pricePerCup = 180;
                    break;
                default:
                    System.out.println("Invalid coffee type. Please try again.");
                    continue; // Skip rest of loop and ask again
            }

            // Calculate bill
            double totalPrice = pricePerCup * quantity;
            double gstAmount = totalPrice * GST_RATE;
            double finalBill = totalPrice + gstAmount;

            // Display bill details
            System.out.println("Base Amount : ₹" + totalPrice);
            System.out.println("GST (5%)    : ₹" + gstAmount);
            System.out.println("Total Bill  : ₹" + finalBill);
        }

        scanner.close();
    }
}
