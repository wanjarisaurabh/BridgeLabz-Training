package com.parcelTracker;

//class to represent parcel
public class Parcel {
	//parcel details
	String parcelId;
	String customerName;
	String destination;
	String currentStage;
	
	public Parcel(String parcelId, String customerName, String destination) {
		this.parcelId = parcelId;
		this.customerName = customerName;
		this.destination = destination;
		this.currentStage = "Packed";
	}
	
	//method to display parcel info
	public void displayInfo() {
		System.out.println("Parcel ID: " + parcelId);
		System.out.println("Customer: " + customerName);
		System.out.println("Destination: " + destination);
		System.out.println("Current Stage: " + currentStage);
	}
}
