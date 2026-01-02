
package EWallet;

public abstract class Wallet implements Transferrable {
    private double balance;

    public Wallet(double balance) {
        this.balance = balance;
    }

    protected boolean hasSufficientBalance(double amount) {
        return balance >= amount;
    }

    protected void debit(double amount) {
        balance -= amount;
    }

    protected void credit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
