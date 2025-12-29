
import java.util.Scanner;

/*
 * Program Name : PhoneRechargeSimulator
 * Description  : Shows offers and updates balance
 */
public class PhoneRechargeSimulator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 0;

        while (true) {
            System.out.print("Enter operator (Jio/Airtel/VI) or Exit: ");
            String operator = sc.next();

            if (operator.equalsIgnoreCase("Exit")) {
                break;
            }

            System.out.print("Enter recharge amount: ");
            double amount = sc.nextDouble();
            balance += amount;

            switch (operator.toLowerCase()) {
                case "jio":
                    System.out.println("Offer: 1.5GB/day");
                    break;
                case "airtel":
                    System.out.println("Offer: Unlimited Calls");
                    break;
                case "vi":
                    System.out.println("Offer: Weekend Data Roll-over");
                    break;
                default:
                    System.out.println("Invalid operator!");
            }

            System.out.println("Current Balance: ₹" + balance);
        }
    }
}
