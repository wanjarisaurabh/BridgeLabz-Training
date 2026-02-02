package com.workshop.smartcity.service;

import com.workshop.smartcity.model.Trip;
import java.util.List;

public interface TransportService {
    String getServiceType();
    List<Trip> getAvailableTrips();

    default void printServiceDetails() {
        System.out.println("Service Type: " + getServiceType());
        System.out.println("Available Trips:");
        getAvailableTrips().forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");
    }

    default boolean isEmergencyService() {
        return this instanceof EmergencyService;
    }
}