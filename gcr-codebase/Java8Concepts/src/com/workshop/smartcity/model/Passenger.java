package com.workshop.smartcity.model;

public class Passenger {
    private String name;
    private String id;
    private double farePaid;
    private String routeId;
    private boolean isPeakTime;

    // constructor
    public Passenger(String name, String id, double farePaid, String routeId, boolean isPeakTime) {
	this.name = name;
	this.id = id;
	this.farePaid = farePaid;
	this.routeId = routeId;
	this.isPeakTime = isPeakTime;
    }

    public String getName() {
	return name;
    }

    public double getFarePaid() {
	return farePaid;
    }

    public String getRouteId() {
	return routeId;
    }

    public boolean isPeakTime() {
	return isPeakTime;
    }

    // good string representation
    @Override
    public String toString() {
	return name + " (Route: " + routeId + ", Fare: Rs." + farePaid + ", Peak: " + isPeakTime + ")";
    }
}