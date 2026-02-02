package com.workshop.smartcity.dashboard;

import com.workshop.smartcity.model.*;
import com.workshop.smartcity.service.*;
import com.workshop.smartcity.util.*;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class SmartCityApp {
    public static void main(String[] args) {

        // 1. Create services
        List<TransportService> services = new ArrayList<>();
        services.add(new BusService());
        services.add(new MetroService());
        services.add(new TaxiService());
        services.add(new EvChargingStation());

        // 2. Dashboard - show all services (forEach + method reference)
        System.out.println("============================ Smart City Transport Dashboard ============================\n");
        System.out.println("Current Active Services:");
        services.forEach(TransportService::printServiceDetails);

        // 3. Emergency check (marker interface)
        System.out.println("Emergency services active? " +
                services.stream().anyMatch(TransportService :: isEmergencyService));

        // 4. Lambda + sorting + filtering available trips (earliest first)
        System.out.println("\nEarliest available trips (sorted by time):");
        services.stream()
                .flatMap(s -> s.getAvailableTrips().stream())
                .sorted(Comparator.comparing(Trip::getDepartureTime))
                .limit(5)
                .forEach(System.out::println);

        // 5. Functional interface - dynamic fare calculation (lambda)
        FareCalculator peakFare = (distance, base, isPeak) -> base + (isPeak ? 15 : 0) + distance * 3.5;
        FareCalculator normalFare = (distance, base, isPeak) -> base + distance * 3.0;

        System.out.println("\nExample fare calculation (distance 12.5 km):");
        double dist = GeoUtils.calculateDistance(
                new Location(23.2599, 77.4126),
                new Location(23.1815, 77.4350)
        );
        System.out.println("Peak fare    : Rs." + peakFare.calculateFare(dist, 35, true));
        System.out.println("Normal fare  : Rs." + normalFare.calculateFare(dist, 35, false));

        // 6. Sample passenger data for analytics
        List<Passenger> passengers = Arrays.asList(
                new Passenger("Abhishek", "P001", 45.0, "B101", true),
                new Passenger("Priya", "P002", 28.0, "M201", false),
                new Passenger("Rohan", "P003", 180.0, "T301", true),
                new Passenger("Sneha", "P004", 42.0, "B101", true),
                new Passenger("Vikram", "P005", 35.0, "B101", false)
        );

        // 7. Collectors examples
        System.out.println("\nRevenue Summary by Route:");
        Map<String, Double> revenueByRoute = passengers.stream()
                .collect(Collectors.groupingBy(
                        Passenger::getRouteId,
                        Collectors.summingDouble(Passenger::getFarePaid)
                ));
        revenueByRoute.forEach((route, total) ->
                System.out.printf("Route %s --> Total revenue: Rs.%.2f%n", route, total));

        System.out.println("\nPeak vs Non-Peak Trips:");
        Map<Boolean, List<Passenger>> peakVsNormal = passengers.stream()
                .collect(Collectors.partitioningBy(Passenger::isPeakTime));
        System.out.println("Peak time trips: " + peakVsNormal.get(true).size());
        System.out.println("Non-peak trips : " + peakVsNormal.get(false).size());

        System.out.println("\n============================= Dashboard Update Complete ===================================");
    }
}