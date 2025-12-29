
import java.util.Scanner;

/*
 * Program Name : MetroSmartCard
 * Description  : Deducts fare based on distance
 */
public class MetroSmartCard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 200;

        while (balance > 0) {
            System.out.print("Enter distance (km) or 0 to exit: ");
            int distance = sc.nextInt();

            if (distance == 0) {
                break;
            }

            // Fare calculation using ternary operator
            double fare = distance <= 5 ? 10 : distance <= 15 ? 20 : 30;

            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare deducted: ₹" + fare);
            } else {
                System.out.println("Insufficient balance!");
                break;
            }

            System.out.println("Remaining balance: ₹" + balance);
        }
    }
}
