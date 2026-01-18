package com.scenariobasedquestion.payxpress;

import java.time.LocalDate;

//water bill class
public class WaterBill extends Bill implements IPayable {
	//water specific details
	private int gallonsUsed;
	private double ratePerGallon;
	
	//constructor with gallons and rate
	public WaterBill(String billId, String customerName, int gallonsUsed, 
			double ratePerGallon, LocalDate dueDate) {
		super(billId, customerName, "Water", gallonsUsed * ratePerGallon, dueDate);
		this.gallonsUsed = gallonsUsed;
		this.ratePerGallon = ratePerGallon;
	}
	
	//constructor for recurring monthly bill
	public WaterBill(String billId, String customerName, int gallonsUsed, 
			double ratePerGallon, int daysFromNow) {
		super(billId, customerName, "Water", gallonsUsed * ratePerGallon, daysFromNow);
		this.gallonsUsed = gallonsUsed;
		this.ratePerGallon = ratePerGallon;
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
		System.out.println("║ Bill Type: Water Bill");
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
		
		System.out.println("\n💧 WATER BILL REMINDER 💧");
		System.out.println("Dear " + getCustomerName() + ",");
		System.out.println("Your water bill is due on " + getDueDate());
		System.out.printf("Amount: Rs %.2f for %d gallons used%n", getBaseAmount(), gallonsUsed);
		
		if (isOverdue()) {
			System.out.println("⚠ OVERDUE! Late fee of Rs " + calculateLateFee() + " has been added");
			System.out.printf("Total Due: Rs %.2f%n", getTotalAmount());
		}
		
		System.out.println("Please pay to avoid water supply disconnection.");
	}
	
	@Override
	public String getBillDetails() {
		return String.format("Gallons: %d | Rate: Rs %.2f/gallon", gallonsUsed, ratePerGallon);
	}
}
