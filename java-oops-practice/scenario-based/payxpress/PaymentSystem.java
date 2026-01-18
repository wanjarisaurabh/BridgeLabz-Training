package com.scenariobasedquestion.payxpress;

import java.util.HashMap;

//class to manage payment system
public class PaymentSystem {
	//hashmap to store all bills
	private static HashMap<String, Bill> bills = new HashMap<>();
	
	//method to add bill to system
	public static boolean addBill(Bill bill) {
		if (bills.containsKey(bill.getBillId())) {
			System.out.println("Bill with ID " + bill.getBillId() + " already exists");
			return false;
		}
		
		bills.put(bill.getBillId(), bill);
		System.out.println("✓ Bill added successfully: " + bill.getBillType() + " - " + bill.getBillId());
		return true;
	}
	
	//method to process payment using polymorphism
	public static void processPayment(String billId) {
		if (!bills.containsKey(billId)) {
			System.out.println("Bill with ID " + billId + " not found");
			return;
		}
		
		Bill bill = bills.get(billId);
		
		//polymorphic call to pay method
		if (bill instanceof IPayable) {
			((IPayable) bill).pay();
		}
	}
	
	//method to send reminder using polymorphism
	public static void sendReminder(String billId) {
		if (!bills.containsKey(billId)) {
			System.out.println("Bill with ID " + billId + " not found");
			return;
		}
		
		Bill bill = bills.get(billId);
		
		//polymorphic call to sendReminder method
		if (bill instanceof IPayable) {
			((IPayable) bill).sendReminder();
		}
	}
	
	//method to send reminders to all unpaid bills
	public static void sendAllReminders() {
		if (bills.isEmpty()) {
			System.out.println("No bills in system");
			return;
		}
		
		System.out.println("\n===== SENDING REMINDERS =====");
		int count = 0;
		
		for (Bill bill : bills.values()) {
			if (!bill.isPaid() && bill instanceof IPayable) {
				((IPayable) bill).sendReminder();
				System.out.println("---");
				count++;
			}
		}
		
		if (count == 0) {
			System.out.println("All bills are paid!");
		} else {
			System.out.println("Total Reminders Sent: " + count);
		}
	}
	
	//method to display all bills
	public static void displayAllBills() {
		if (bills.isEmpty()) {
			System.out.println("No bills in system");
			return;
		}
		
		System.out.println("\n╔════════════════════════════════════════════════════╗");
		System.out.println("║              ALL BILLS                             ║");
		System.out.println("╠════════════════════════════════════════════════════╣");
		
		for (Bill bill : bills.values()) {
			System.out.println("║ ");
			bill.displayBillInfo();
			System.out.println("║   " + bill.getBillDetails());
			System.out.println("╠════════════════════════════════════════════════════╣");
		}
		
		System.out.println("Total Bills: " + bills.size());
	}
	
	//method to display unpaid bills
	public static void displayUnpaidBills() {
		System.out.println("\n===== UNPAID BILLS =====");
		
		int count = 0;
		double totalDue = 0;
		
		for (Bill bill : bills.values()) {
			if (!bill.isPaid()) {
				bill.displayBillInfo();
				System.out.println("---");
				count++;
				totalDue += bill.getTotalAmount();
			}
		}
		
		if (count == 0) {
			System.out.println("All bills are paid!");
		} else {
			System.out.println("Total Unpaid Bills: " + count);
			System.out.printf("Total Amount Due: Rs %.2f%n", totalDue);
		}
	}
	
	//method to display overdue bills
	public static void displayOverdueBills() {
		System.out.println("\n===== OVERDUE BILLS =====");
		
		int count = 0;
		double totalOverdue = 0;
		
		for (Bill bill : bills.values()) {
			if (bill.isOverdue()) {
				bill.displayBillInfo();
				System.out.println("---");
				count++;
				totalOverdue += bill.getTotalAmount();
			}
		}
		
		if (count == 0) {
			System.out.println("No overdue bills");
		} else {
			System.out.println("Total Overdue Bills: " + count);
			System.out.printf("Total Amount Overdue: Rs %.2f%n", totalOverdue);
		}
	}
	
	//method to display paid bills
	public static void displayPaidBills() {
		System.out.println("\n===== PAID BILLS =====");
		
		int count = 0;
		
		for (Bill bill : bills.values()) {
			if (bill.isPaid()) {
				bill.displayBillInfo();
				System.out.println("---");
				count++;
			}
		}
		
		if (count == 0) {
			System.out.println("No paid bills");
		} else {
			System.out.println("Total Paid Bills: " + count);
		}
	}
	
	//method to generate payment report
	public static void generateReport() {
		int totalBills = bills.size();
		int paidBills = 0;
		int unpaidBills = 0;
		int overdueBills = 0;
		double totalPaid = 0;
		double totalDue = 0;
		double totalLateFees = 0;
		
		for (Bill bill : bills.values()) {
			if (bill.isPaid()) {
				paidBills++;
				totalPaid += bill.getBaseAmount();
			} else {
				unpaidBills++;
				totalDue += bill.getTotalAmount();
				totalLateFees += bill.calculateLateFee();
				
				if (bill.isOverdue()) {
					overdueBills++;
				}
			}
		}
		
		System.out.println("\n╔════════════════════════════════════════════════════╗");
		System.out.println("║           PAYMENT SYSTEM REPORT                    ║");
		System.out.println("╠════════════════════════════════════════════════════╣");
		System.out.println("║ Total Bills: " + String.format("%-38d", totalBills) + "║");
		System.out.println("╠════════════════════════════════════════════════════╣");
		System.out.println("║ Paid Bills: " + String.format("%-39d", paidBills) + "║");
		System.out.println("║ Unpaid Bills: " + String.format("%-37d", unpaidBills) + "║");
		System.out.println("║ Overdue Bills: " + String.format("%-36d", overdueBills) + "║");
		System.out.println("╠════════════════════════════════════════════════════╣");
		System.out.printf("║ Total Paid Amount: Rs %-28.2f║%n", totalPaid);
		System.out.printf("║ Total Due Amount: Rs %-29.2f║%n", totalDue);
		System.out.printf("║ Total Late Fees: Rs %-30.2f║%n", totalLateFees);
		System.out.println("╚════════════════════════════════════════════════════╝");
	}
	
	//method to search bill by ID
	public static Bill searchBillById(String billId) {
		if (!bills.containsKey(billId)) {
			System.out.println("Bill with ID " + billId + " not found");
			return null;
		}
		
		return bills.get(billId);
	}
	
	//method to remove bill
	public static boolean removeBill(String billId) {
		if (!bills.containsKey(billId)) {
			System.out.println("Bill with ID " + billId + " not found");
			return false;
		}
		
		Bill bill = bills.get(billId);
		bills.remove(billId);
		System.out.println("✓ Bill " + billId + " removed from system");
		return true;
	}
}
