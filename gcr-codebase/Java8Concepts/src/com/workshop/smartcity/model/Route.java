package com.workshop.smartcity.model;

public class Route {
    private String routeId;
    private Location start;
    private Location end;
    private double baseFare;

    // constructor
    public Route(String routeId, Location start, Location end, double baseFare) {
	this.routeId = routeId;
	this.start = start;
	this.end = end;
	this.baseFare = baseFare;
    }

    public String getRouteId() {
	return routeId;
    }

    public Location getStart() {
	return start;
    }

    public Location getEnd() {
	return end;
    }

    public double getBaseFare() {
	return baseFare;
    }
}