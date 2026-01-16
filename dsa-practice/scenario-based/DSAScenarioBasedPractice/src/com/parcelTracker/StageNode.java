package com.parcelTracker;

//node class to represent each stage in delivery chain
public class StageNode {
	//stage details
	String stageName;
	String timestamp;
	String location;
	StageNode next;
	
	public StageNode(String stageName, String location, String timestamp) {
		this.stageName = stageName;
		this.location = location;
		this.timestamp = timestamp;
		this.next = null;
	}
	
	//method to display stage details
	public void displayStage() {
		System.out.println("→ " + stageName + " | Location: " + location + " | Time: " + timestamp);
	}
}
