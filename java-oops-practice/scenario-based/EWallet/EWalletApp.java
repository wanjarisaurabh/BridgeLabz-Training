
package EWallet;

public class EWalletApp {
    public static void main(String[] args) {

        User user1 = new User("Saurabh");
        User user2 = new User("Rohit");

        Wallet wallet = new PersonalWallet(5000);

        wallet.transferTo(user2, 1500);
        System.out.println("Remaining Balance: " + wallet.getBalance());
    }
}
