package com.scenariobasedquestion.payxpress;

import java.time.LocalDate;

//base class for all bills
public abstract class Bill {
	//bill details - encapsulated with private access
	private String billId;
	private String customerName;
	private String billType;
	private double baseAmount;
	private LocalDate dueDate;
	private boolean isPaid;
	private LocalDate paidDate;
	
	//constructor for new bills
	public Bill(String billId, String customerName, String billType, double baseAmount, LocalDate dueDate) {
		this.billId = billId;
		this.customerName = customerName;
		this.billType = billType;
		this.baseAmount = baseAmount;
		this.dueDate = dueDate;
		this.isPaid = false;
		this.paidDate = null;
	}
	
	//constructor for recurring bills
	public Bill(String billId, String customerName, String billType, double baseAmount, int daysFromNow) {
		this.billId = billId;
		this.customerName = customerName;
		this.billType = billType;
		this.baseAmount = baseAmount;
		this.dueDate = LocalDate.now().plusDays(daysFromNow);
		this.isPaid = false;
		this.paidDate = null;
	}
	
	//getters - read-only access
	public String getBillId() {
		return billId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public String getBillType() {
		return billType;
	}
	
	public double getBaseAmount() {
		return baseAmount;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	public boolean isPaid() {
		return isPaid;
	}
	
	public LocalDate getPaidDate() {
		return paidDate;
	}
	
	//method to calculate late fee penalty
	public double calculateLateFee() {
		if (isPaid || !isOverdue()) {
			return 0.0;
		}
		
		long daysOverdue = java.time.temporal.ChronoUnit.DAYS.between(dueDate, LocalDate.now());
		double penalty = daysOverdue * 10.0; //Rs 10 per day late fee
		
		return penalty;
	}
	
	//method to calculate total amount with late fee
	public double getTotalAmount() {
		return baseAmount + calculateLateFee();
	}
	
	//method to check if bill is overdue
	public boolean isOverdue() {
		return !isPaid && LocalDate.now().isAfter(dueDate);
	}
	
	//protected method to mark as paid - only accessible within payment system
	protected void markAsPaid() {
		this.isPaid = true;
		this.paidDate = LocalDate.now();
	}
	
	//method to display bill info
	public void displayBillInfo() {
		System.out.println("Bill ID: " + billId);
		System.out.println("Customer: " + customerName);
		System.out.println("Type: " + billType);
		System.out.printf("Base Amount: Rs %.2f%n", baseAmount);
		System.out.println("Due Date: " + dueDate);
		System.out.println("Status: " + (isPaid ? "PAID" : "UNPAID"));
		
		if (isPaid) {
			System.out.println("Paid On: " + paidDate);
		} else if (isOverdue()) {
			System.out.printf("Late Fee: Rs %.2f%n", calculateLateFee());
			System.out.printf("Total Due: Rs %.2f%n", getTotalAmount());
		}
	}
	
	//abstract method for bill-specific details
	public abstract String getBillDetails();
}
