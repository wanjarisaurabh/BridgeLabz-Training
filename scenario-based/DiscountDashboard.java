
import java.util.Scanner;

/*
 * Program Name : DiscountDashboard
 * Description  : Calculates discount on total bill
 */
public class DiscountDashboard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter price of item " + i + ": ");
            total += sc.nextDouble();
        }

        double discount;
        if (total >= 5000) {
            discount = 0.20; 
        }else if (total >= 2000) {
            discount = 0.10; 
        }else {
            discount = 0.0;
        }

        double finalAmount = total - (total * discount);

        System.out.println("Total Bill: ₹" + total);
        System.out.println("Final Amount: ₹" + finalAmount);
    }
}
