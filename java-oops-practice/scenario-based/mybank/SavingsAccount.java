package mybank;

class SavingsAccount extends Account {

    private final double interestRate = 4.0;

    public SavingsAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

