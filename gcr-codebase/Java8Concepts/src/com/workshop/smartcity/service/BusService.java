package com.workshop.smartcity.service;

import com.workshop.smartcity.model.Location;
import com.workshop.smartcity.model.Route;
import com.workshop.smartcity.model.Trip;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BusService implements TransportService {
    private final List<Trip> trips = new ArrayList<>();

    // constructor
    public BusService() {
        Route r1 = new Route("B101", new Location(23.2599, 77.4126), new Location(23.1815, 77.4350), 35.0);
        trips.add(new Trip(r1, LocalTime.of(7, 0), 35.0));
        trips.add(new Trip(r1, LocalTime.of(8, 30), 40.0)); // peak
        trips.add(new Trip(r1, LocalTime.of(17, 45), 38.0));
    }

    @Override
    public String getServiceType() {
        return "Bus";
    }

    @Override
    public List<Trip> getAvailableTrips() {
        return new ArrayList<>(trips);
    }
}