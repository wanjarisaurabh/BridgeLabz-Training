package com.cropmonitor;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number of sensor readings: ");
		int n = input.nextInt();
		
		SensorData[] readings = new SensorData[n];
		
		// input sensor data
		for (int i = 0; i < n; i++) {
			System.out.println("Enter location: ");
			String location = input.next();
			
			System.out.println("Enter temperature (°C): ");
			double temp = input.nextDouble();
			
			System.out.println("Enter timestamp (HH:MM:SS): ");
			String time = input.next();
			
			readings[i] = new SensorData(location, temp, time);
		}
		
		// sort by timestamp using quick sort
		SensorData.sortData(readings);
		
		// display sorted data
		System.out.println("\n=== SENSOR DATA (Sorted by Timestamp) ===");
		System.out.printf("%-15s %-15s %-12s\n", "Location", "Temperature", "Timestamp");
		System.out.println("-----------------------------------------------");
		
		for (int i = 0; i < n; i++) {
			System.out.printf("%-15s %-15.2f %-12s\n", 
				readings[i].location, 
				readings[i].temperature, 
				readings[i].timestamp);
		}
		
		input.close();
	}
}
