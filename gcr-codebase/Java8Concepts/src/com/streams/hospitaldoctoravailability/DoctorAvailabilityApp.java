package com.streams.hospitaldoctoravailability;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DoctorAvailabilityApp {
    public static void main(String[] args) {
        // sample list of doctors (as if from hospital database)
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Dr. Rajesh Mehta", "Cardiology", "Mon-Wed-Fri"));
        doctors.add(new Doctor("Dr. Priya Sharma", "Pediatrics", "Sat-Sun"));
        doctors.add(new Doctor("Dr. Anjali Verma", "Neurology", "Tue-Thu-Sat"));
        doctors.add(new Doctor("Dr. Vikram Singh", "Orthopedics", "All Days"));
        doctors.add(new Doctor("Dr. Sneha Kapoor", "Dermatology", "Fri-Sun"));
        doctors.add(new Doctor("Dr. Amit Patel", "General Medicine", "Mon-Fri"));
        doctors.add(new Doctor("Dr. Neha Gupta", "Gynecology", "Sat-Sun"));
        doctors.add(new Doctor("Dr. Rohan Joshi", "ENT", "Wed-Sat"));

        System.out.println("Hospital Doctor Availability - Weekend Doctors");
        System.out.println("Sorted by Specialty (A-Z)");
        System.out.println("-------------------------------------------------------------");

        // Stream: filter weekend availability -> sort by specialty -> print
        doctors.stream()
                .filter(Doctor::isAvailableOnWeekend) // available on Sat/Sun
                .sorted(Comparator.comparing(Doctor::getSpecialty)) // sort alphabetically by specialty
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------------------");
        System.out.println("Total weekend-available doctors: " +
                doctors.stream().filter(Doctor::isAvailableOnWeekend).count());
    }
}