package com.cinemahouse;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter number of shows: ");
		int n = input.nextInt();
		
		Movie[] shows = new Movie[n];
		
		// input movie shows
		for (int i = 0; i < n; i++) {
			System.out.println("Enter movie title: ");
			String title = input.next();
			
			System.out.println("Enter showtime (HH:MM): ");
			String time = input.next();
			
			shows[i] = new Movie(title, time);
		}
		
		// sort by time using bubble sort
		Movie.sortShows(shows);
		
		// display sorted schedule
		System.out.println("\n=== TODAY'S MOVIE SCHEDULE ===");
		System.out.printf("%-20s %-10s\n", "Movie Title", "Showtime");
		System.out.println("--------------------------------");
		
		for (int i = 0; i < n; i++) {
			System.out.printf("%-20s %-10s\n", shows[i].title, shows[i].time);
		}
		
		input.close();
	}
}
