
package Banking;

// Helper class demonstrating modular reusable methods
public class BankHelper {

    // Validates user input amount
    public static boolean validateUserInput(double amount) {
        return amount > 0;
    }

    // Checks loan eligibility based on balance
    public static boolean checkLoanEligibility(double balance) {
        return balance >= 50000;
    }

    // Calculates discount on loan processing fee
    public static double calculateDiscount(double fee) {
        return fee * 0.10;
    }
}
