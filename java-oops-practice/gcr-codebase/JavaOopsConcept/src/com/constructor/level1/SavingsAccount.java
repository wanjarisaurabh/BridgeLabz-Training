/*
 * Program Name : SavingsAccount
 * Description  : Access inherited members.
 */

package com.constructor.level1;

class SavingsAccount extends BankAccount {
    SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    void display() {
        System.out.println(accountNumber + " | " + accountHolder + " | " + getBalance());
    }
}
