package com.methodreferences.invoiceobject;

public class Invoice {
    private String transactionId;
    private double amount;
    private String date;

    // constructor used by constructor reference
    public Invoice(String transactionId) {
	this.transactionId = transactionId;
	this.amount = Math.random() * 10000 + 500; // random amount Rs.500–10500
	this.date = "2025-10-15"; // fixed date
    }

    // getters
    public String getTransactionId() {
	return transactionId;
    }

    public double getAmount() {
	return amount;
    }

    public String getDate() {
	return date;
    }

    // good string representation
    @Override
    public String toString() {
	return String.format("Invoice[TxID=%s, Amount=Rs.%.2f, Date=%s]", transactionId, amount, date);
    }
}