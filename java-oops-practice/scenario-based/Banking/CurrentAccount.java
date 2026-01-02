
package Banking;

// CurrentAccount with overdraft limit
public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public boolean canWithdraw(double amount) {
        return (balance + overdraftLimit) >= amount;
    }
}
