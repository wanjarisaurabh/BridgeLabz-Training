
package Banking;

// Base Account class
public abstract class Account {
    protected double balance;
    protected String accountNumber;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
