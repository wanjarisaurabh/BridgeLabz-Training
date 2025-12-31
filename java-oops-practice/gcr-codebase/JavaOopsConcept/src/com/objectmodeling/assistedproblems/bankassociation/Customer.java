package com.objectmodeling.assistedproblems.bankassociation;

public class Customer {
    String name;
    int balance;

    Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    void viewBalance() {
        System.out.println(balance);
    }
}
