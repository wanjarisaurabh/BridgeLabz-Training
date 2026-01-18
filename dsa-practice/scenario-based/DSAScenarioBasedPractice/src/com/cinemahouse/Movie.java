package com.cinemahouse;

public class Movie {
	String title;
	String time;
	
	// constructor
	public Movie(String title, String time) {
		this.title = title;
		this.time = time;
	}
	
	// convert time to minutes for comparison
	private static int timeToMinutes(String time) {
		String[] parts = time.split(":");
		return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
	}
	
	// bubble sort - sorts by showtime
	public static void sortShows(Movie[] shows) {
		int n = shows.length;
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				// compare showtimes
				if (timeToMinutes(shows[j].time) > timeToMinutes(shows[j + 1].time)) {
					// swap
					Movie temp = shows[j];
					shows[j] = shows[j + 1];
					shows[j + 1] = temp;
				}
			}
		}
	}
}
