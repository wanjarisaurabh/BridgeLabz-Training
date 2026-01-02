
package Banking;

public class BankingApp {
    public static void main(String[] args) {

        Customer customer = new Customer("Saurabh", 501);
        SavingsAccount savings = new SavingsAccount("SA101", 80000, 0.04);

        System.out.println(customer.getCustomerDetails());
        System.out.println("Interest Earned: " + savings.calculateInterest());

        double fee = 2000;
        double discount = BankHelper.calculateDiscount(fee);
        System.out.println("Processing Fee after Discount: " + (fee - discount));
    }
}
