package com.objectmodeling.assistedproblems.bankassociation;



public class BankTest {
    public static void main(String[] args) {
        Bank b = new Bank();
        Customer c = new Customer("Saurabh", 5000);
        b.openAccount(c);
    }
}
