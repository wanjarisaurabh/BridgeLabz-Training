package com.workshop.smartcity.model;

import java.time.LocalTime;

public class Trip {
    private Route route;
    private LocalTime departureTime;
    private double currentFare;

    // constructor
    public Trip(Route route, LocalTime departureTime, double currentFare) {
	this.route = route;
	this.departureTime = departureTime;
	this.currentFare = currentFare;
    }

    public Route getRoute() {
	return route;
    }

    public LocalTime getDepartureTime() {
	return departureTime;
    }

    public double getCurrentFare() {
	return currentFare;
    }

    // good string representation
    @Override
    public String toString() {
	return "Route " + route.getRouteId() + " | Dep: " + departureTime + " | Fare: Rs." + currentFare;
    }
}