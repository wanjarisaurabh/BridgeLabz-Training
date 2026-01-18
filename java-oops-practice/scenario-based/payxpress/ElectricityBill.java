package com.scenariobasedquestion.payxpress;

import java.time.LocalDate;

//electricity bill class
public class ElectricityBill extends Bill implements IPayable {
	//electricity specific details
	private int unitsConsumed;
	private double ratePerUnit;
	
	//constructor with units and rate
	public ElectricityBill(String billId, String customerName, int unitsConsumed, 
			double ratePerUnit, LocalDate dueDate) {
		super(billId, customerName, "Electricity", unitsConsumed * ratePerUnit, dueDate);
		this.unitsConsumed = unitsConsumed;
		this.ratePerUnit = ratePerUnit;
	}
	
	//constructor for recurring monthly bill
	public ElectricityBill(String billId, String customerName, int unitsConsumed, 
			double ratePerUnit, int daysFromNow) {
		super(billId, customerName, "Electricity", unitsConsumed * ratePerUnit, daysFromNow);
		this.unitsConsumed = unitsConsumed;
		this.ratePerUnit = ratePerUnit;
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
		System.out.println("║ Bill Type: Electricity Bill");
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
		
		System.out.println("\n⚡ ELECTRICITY BILL REMINDER ⚡");
		System.out.println("Dear " + getCustomerName() + ",");
		System.out.println("Your electricity bill is due on " + getDueDate());
		System.out.printf("Amount: Rs %.2f for %d units consumed%n", getBaseAmount(), unitsConsumed);
		
		if (isOverdue()) {
			System.out.println("⚠ OVERDUE! Late fee of Rs " + calculateLateFee() + " has been added");
			System.out.printf("Total Due: Rs %.2f%n", getTotalAmount());
		}
		
		System.out.println("Please pay to avoid power disconnection.");
	}
	
	@Override
	public String getBillDetails() {
		return String.format("Units: %d | Rate: Rs %.2f/unit", unitsConsumed, ratePerUnit);
	}
}
