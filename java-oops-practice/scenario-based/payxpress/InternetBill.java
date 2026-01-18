package com.scenariobasedquestion.payxpress;

import java.time.LocalDate;

//internet bill class
public class InternetBill extends Bill implements IPayable {
	//internet specific details
	private String planType;
	private int speedMbps;
	
	//constructor with plan details
	public InternetBill(String billId, String customerName, String planType, 
			int speedMbps, double amount, LocalDate dueDate) {
		super(billId, customerName, "Internet", amount, dueDate);
		this.planType = planType;
		this.speedMbps = speedMbps;
	}
	
	//constructor for recurring monthly bill
	public InternetBill(String billId, String customerName, String planType, 
			int speedMbps, double amount, int daysFromNow) {
		super(billId, customerName, "Internet", amount, daysFromNow);
		this.planType = planType;
		this.speedMbps = speedMbps;
	}
	
	@Override
	public void pay() {
		if (isPaid()) {
			System.out.println("Bill " + getBillId() + " is already paid");
			return;
		}
		
		markAsPaid();
		System.out.println("╔════════════════════════════════════════════════════╗");
		System.out.println("║           PAYMENT SUCCESSFUL                       ║");
		System.out.println("╠════════════════════════════════════════════════════╣");
		System.out.println("║ Bill Type: Internet Bill");
		System.out.println("║ Bill ID: " + getBillId());
		System.out.println("║ Customer: " + getCustomerName());
		System.out.printf("║ Amount Paid: Rs %.2f%n", getTotalAmount());
		System.out.println("║ Payment Date: " + LocalDate.now());
		System.out.println("╚════════════════════════════════════════════════════╝");
	}
	
	@Override
	public void sendReminder() {
		if (isPaid()) {
			System.out.println("Bill already paid. No reminder needed.");
			return;
		}
		
		System.out.println("\n📡 INTERNET BILL REMINDER 📡");
		System.out.println("Dear " + getCustomerName() + ",");
		System.out.println("Your internet bill is due on " + getDueDate());
		System.out.printf("Amount: Rs %.2f for %s plan (%d Mbps)%n", 
				getBaseAmount(), planType, speedMbps);
		
		if (isOverdue()) {
			System.out.println("⚠ OVERDUE! Late fee of Rs " + calculateLateFee() + " has been added");
			System.out.printf("Total Due: Rs %.2f%n", getTotalAmount());
		}
		
		System.out.println("Please pay to avoid internet service suspension.");
	}
	
	@Override
	public String getBillDetails() {
		return String.format("Plan: %s | Speed: %d Mbps", planType, speedMbps);
	}
}
