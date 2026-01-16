package com.parcelTracker;

import java.util.HashMap;

//class to manage all parcels in courier company
public class CourierCompany {
	//hashmap to store parcels by their ID
	private static HashMap<String, DeliveryChain> parcels = new HashMap<>();
	
	//method to register new parcel
	public static boolean registerParcel(String parcelId, String customerName, String destination) {
		if (parcels.containsKey(parcelId)) {
			System.out.println("Parcel with ID " + parcelId + " already exists");
			return false;
		}
		
		Parcel parcel = new Parcel(parcelId, customerName, destination);
		DeliveryChain chain = new DeliveryChain(parcel);
		
		//automatically add first stage
		chain.addStage("Packed", "Warehouse", getCurrentTimestamp());
		
		parcels.put(parcelId, chain);
		System.out.println("✓ Parcel registered successfully");
		return true;
	}
	
	//method to update parcel stage
	public static boolean updateStage(String parcelId, String stageName, String location) {
		if (!parcels.containsKey(parcelId)) {
			System.out.println("Parcel with ID " + parcelId + " not found");
			return false;
		}
		
		DeliveryChain chain = parcels.get(parcelId);
		chain.addStage(stageName, location, getCurrentTimestamp());
		return true;
	}
	
	//method to add custom checkpoint
	public static boolean addCheckpoint(String parcelId, String checkpointName, String location) {
		if (!parcels.containsKey(parcelId)) {
			System.out.println("Parcel with ID " + parcelId + " not found");
			return false;
		}
		
		DeliveryChain chain = parcels.get(parcelId);
		chain.addCustomCheckpoint(checkpointName, location, getCurrentTimestamp());
		return true;
	}
	
	//method to track parcel
	public static void trackParcel(String parcelId) {
		if (!parcels.containsKey(parcelId)) {
			System.out.println("Parcel with ID " + parcelId + " not found");
			return;
		}
		
		DeliveryChain chain = parcels.get(parcelId);
		chain.trackParcel();
	}
	
	//method to report lost parcel
	public static void reportLostParcel(String parcelId, String reason) {
		if (!parcels.containsKey(parcelId)) {
			System.out.println("Parcel with ID " + parcelId + " not found");
			return;
		}
		
		DeliveryChain chain = parcels.get(parcelId);
		chain.reportLost(reason);
	}
	
	//method to show all parcels
	public static void showAllParcels() {
		if (parcels.isEmpty()) {
			System.out.println("No parcels in system");
			return;
		}
		
		System.out.println("\n===== ALL PARCELS =====");
		for (String parcelId : parcels.keySet()) {
			DeliveryChain chain = parcels.get(parcelId);
			System.out.println("ID: " + parcelId + " | Customer: " + chain.parcel.customerName + 
					" | Stage: " + chain.getCurrentStage());
		}
	}
	
	//helper method to get current timestamp
	private static String getCurrentTimestamp() {
		return java.time.LocalDateTime.now().format(
				java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}
