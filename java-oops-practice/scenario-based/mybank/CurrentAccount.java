package mybank;

class CurrentAccount extends Account {

    private final double interestRate = 1.5;

    public CurrentAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

