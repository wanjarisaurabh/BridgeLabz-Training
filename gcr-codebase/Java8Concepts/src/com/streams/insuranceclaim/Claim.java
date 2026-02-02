package com.streams.insuranceclaim;

public class Claim {
    private String claimId;
    private String claimType; // Health, Motor, Travel, Home, Life
    private double amount;
    private String status; // Approved, Pending, Rejected

    // constructor
    public Claim(String claimId, String claimType, double amount, String status) {
	this.claimId = claimId;
	this.claimType = claimType;
	this.amount = amount;
	this.status = status;
    }

    // getters
    public String getClaimType() {
	return claimType;
    }

    public double getAmount() {
	return amount;
    }

    // good string representation
    @Override
    public String toString() {
	return String.format("Claim[%s | Type: %s | Amount: Rs.%.2f | Status: %s]", claimId, claimType, amount, status);
    }
}