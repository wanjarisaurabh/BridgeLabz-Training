
package EWallet;

public class PersonalWallet extends Wallet {

    public PersonalWallet(double balance) {
        super(balance);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        if (hasSufficientBalance(amount)) {
            debit(amount);
            System.out.println("Transferred " + amount + " to " + receiver.getName());
        }
    }
}
