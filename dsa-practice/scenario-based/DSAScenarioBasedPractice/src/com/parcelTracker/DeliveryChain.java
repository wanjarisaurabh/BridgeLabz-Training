package com.parcelTracker;

//class to manage delivery chain using singly linked list
public class DeliveryChain {
	//parcel details
	Parcel parcel;
	StageNode head;
	StageNode tail;
	int stageCount;
	
	public DeliveryChain(Parcel parcel) {
		this.parcel = parcel;
		this.head = null;
		this.tail = null;
		this.stageCount = 0;
	}
	
	//method to add stage to delivery chain
	public void addStage(String stageName, String location, String timestamp) {
		StageNode newStage = new StageNode(stageName, location, timestamp);
		
		if (head == null) {
			head = newStage;
			tail = newStage;
		} else {
			tail.next = newStage;
			tail = newStage;
		}
		
		parcel.currentStage = stageName;
		stageCount++;
		System.out.println("✓ Stage added: " + stageName);
	}
	
	//method to track parcel through all stages
	public void trackParcel() {
		if (head == null) {
			System.out.println("No tracking information available");
			return;
		}
		
		System.out.println("\n===== PARCEL TRACKING =====");
		parcel.displayInfo();
		System.out.println("\n--- Delivery Chain ---");
		
		StageNode current = head;
		int position = 1;
		
		while (current != null) {
			System.out.print("Stage " + position + " ");
			current.displayStage();
			current = current.next;
			position++;
		}
		
		System.out.println("Total Stages: " + stageCount);
	}
	
	//method to check if parcel is delivered
	public boolean isDelivered() {
		if (tail != null && tail.stageName.equalsIgnoreCase("Delivered")) {
			return true;
		}
		return false;
	}
	
	//method to handle lost/missing parcel
	public void reportLost(String reason) {
		System.out.println("\n⚠ PARCEL LOST/MISSING ⚠");
		System.out.println("Parcel ID: " + parcel.parcelId);
		System.out.println("Last Known Stage: " + (tail != null ? tail.stageName : "Unknown"));
		System.out.println("Reason: " + reason);
		
		//add lost stage
		addStage("Lost", "Unknown", java.time.LocalDateTime.now().toString());
	}
	
	//method to add custom checkpoint
	public void addCustomCheckpoint(String checkpointName, String location, String timestamp) {
		addStage(checkpointName, location, timestamp);
	}
	
	//method to get current stage
	public String getCurrentStage() {
		if (tail == null) {
			return "No tracking data";
		}
		return tail.stageName;
	}
}
