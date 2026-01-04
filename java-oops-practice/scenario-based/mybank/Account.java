package mybank;

abstract class Account implements ITransaction {

    protected String accountNumber;   // accessible to subclasses
    private double balance;            // encapsulated

    // Constructor without opening balance
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    // Constructor with opening balance
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Encapsulated access
    protected double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Interface methods
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    // Polymorphic method
    public abstract double calculateInterest();
}

