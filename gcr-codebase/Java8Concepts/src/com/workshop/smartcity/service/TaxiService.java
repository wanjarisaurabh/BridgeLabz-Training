package com.workshop.smartcity.service;

import com.workshop.smartcity.model.Location;
import com.workshop.smartcity.model.Route;
import com.workshop.smartcity.model.Trip;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TaxiService implements TransportService {
    private final List<Trip> trips = new ArrayList<>();

    // constructor
    public TaxiService() {
        Route r1 = new Route("T301", new Location(23.2599, 77.4126), new Location(23.2200, 77.4300), 180.0);
        trips.add(new Trip(r1, LocalTime.now(), 180.0));
    }

    @Override
    public String getServiceType() {
        return "Taxi";
    }

    @Override
    public List<Trip> getAvailableTrips() {
        return new ArrayList<>(trips);
    }
}