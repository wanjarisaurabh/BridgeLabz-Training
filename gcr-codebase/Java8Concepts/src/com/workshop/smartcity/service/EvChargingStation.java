package com.workshop.smartcity.service;

import java.util.Collections;
import java.util.List;

import com.workshop.smartcity.model.Trip;

public class EvChargingStation implements TransportService {
    
    @Override
    public String getServiceType() {
        return "EV Charging";
    }

    @Override
    public List<Trip> getAvailableTrips() {
        return Collections.emptyList(); // no trips – just stations
    }

    @Override
    public void printServiceDetails() {
        System.out.println("EV Charging Station - 50+ fast chargers available 24×7");
    }
}