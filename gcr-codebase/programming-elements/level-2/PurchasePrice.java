
import java.util.Scanner;

class PurchasePrice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input
        System.out.print("Enter unit price (INR): ");
        double unitPrice = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        //logic code
        double totalPrice = unitPrice * quantity;

        //output
        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
    }
}
