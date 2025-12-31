
import java.util.Scanner;

/*
 * Program: CurrencyExchangeKiosk
 * Description:
 * Converts INR to selected currency.
 * Uses switch-case and do-while loop.
 */
public class CurrencyExchangeKiosk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter amount in INR: ");
            double inr = sc.nextDouble();

            System.out.println("Convert to:");
            System.out.println("1. USD");
            System.out.println("2. EUR");
            System.out.println("3. YEN");

            int option = sc.nextInt();
            double result = 0;

            switch (option) {
                case 1:
                    result = inr * 0.012;
                    System.out.println("USD: " + result);
                    break;
                case 2:
                    result = inr * 0.011;
                    System.out.println("EUR: " + result);
                    break;
                case 3:
                    result = inr * 1.77;
                    System.out.println("YEN: " + result);
                    break;
                default:
                    System.out.println("Invalid currency option!");
            }

            System.out.print("Do you want another conversion? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);

        } while (choice == 'y');
    }
}
