package mybank;

public class MyBankApp {

    public static void main(String[] args) {

        Account acc1 = new SavingsAccount("SB1001", 50000);
        Account acc2 = new CurrentAccount("CA2001", 80000);

        acc1.deposit(5000);
        acc2.withdraw(10000);

        System.out.println("Savings Balance: ₹" + acc1.checkBalance());
        System.out.println("Savings Interest: ₹" + acc1.calculateInterest());

        System.out.println("------------------------");

        System.out.println("Current Balance: ₹" + acc2.checkBalance());
        System.out.println("Current Interest: ₹" + acc2.calculateInterest());
    }
}
