package com.workshop.smartcity.util;

@FunctionalInterface
public interface FareCalculator {
    double calculateFare(double distance, double baseFare, boolean isPeak);
}