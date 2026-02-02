package com.streams.hospitaldoctoravailability;

public class Doctor {
    private String name;
    private String specialty; // e.g., Cardiology, Pediatrics, Orthopedics
    private String availableDays; // e.g., "Mon-Wed-Fri", "Sat-Sun", "All Days"

    // constructor
    public Doctor(String name, String specialty, String availableDays) {
        this.name = name;
        this.specialty = specialty;
        this.availableDays = availableDays;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getAvailableDays() {
        return availableDays;
    }

    // check if doctor is available on weekends
    public boolean isAvailableOnWeekend() {
        String days = availableDays.toLowerCase();
        return days.contains("sat") || days.contains("sun") || days.contains("weekend") || days.contains("all");
    }

    // good string representation
    @Override
    public String toString() {
        return String.format("%-25s | Specialty: %-15s | Available: %s",
                name, specialty, availableDays);
    }
}