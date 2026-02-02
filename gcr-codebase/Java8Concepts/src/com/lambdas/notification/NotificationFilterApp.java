package com.lambdas.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotificationFilterApp {
    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	// sample alerts (as if coming from hospital system)
	List<Alert> alerts = new ArrayList<>();
	alerts.add(new Alert("P001", "Blood pressure dropped", "critical", true));
	alerts.add(new Alert("P002", "Routine checkup reminder", "low", false));
	alerts.add(new Alert("P003", "Fever detected 39.2°C", "high", true));
	alerts.add(new Alert("P004", "Medication time", "medium", false));
	alerts.add(new Alert("P005", "Heart rate irregular", "critical", true));

	System.out.println("Hospital Notification Filtering Demo");
	System.out.println("Available filter options:");
	System.out.println("1 - Show only critical alerts");
	System.out.println("2 - Show urgent alerts only");
	System.out.println("3 - Show high severity or above");
	System.out.println("4 - Show all alerts");
	System.out.print("Choose filter (1-4): ");

	int choice = input.nextInt();
	input.nextLine(); // consume newline

	// define different filtering behaviors using Predicate + lambda
	Predicate<Alert> filter;

	switch (choice) {
	case 1:
	    // only critical severity
	    filter = alert -> "critical".equalsIgnoreCase(alert.getSeverity());
	    break;

	case 2:
	    // only urgent alerts
	    filter = Alert::isUrgent;
	    break;

	case 3:
	    // high or critical
	    filter = alert -> {
		String sev = alert.getSeverity().toLowerCase();
		return sev.equals("high") || sev.equals("critical");
	    };
	    break;

	case 4:
	    // show all (always true)
	    filter = _ -> true;
	    break;

	default:
	    System.out.println("Invalid choice. Showing all alerts.");
	    filter = _ -> true;
	    break;
	}

	// filter alerts using the chosen Predicate (lambda)
	List<Alert> filteredAlerts = alerts.stream().filter(filter).collect(Collectors.toList());

	System.out.println("\nFiltered Notifications (" + filteredAlerts.size() + " shown):");
	if (filteredAlerts.isEmpty()) {
	    System.out.println("No alerts match the selected filter.");
	} else {
	    filteredAlerts.forEach(System.out::println);
	}

	input.close();
    }
}