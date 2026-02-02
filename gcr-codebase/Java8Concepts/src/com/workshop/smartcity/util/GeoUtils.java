package com.workshop.smartcity.util;

import com.workshop.smartcity.model.Location;

public interface GeoUtils {
    static double calculateDistance(Location a, Location b) {
	// Haversine formula
	double lat1 = Math.toRadians(a.getLatitude());
	double lon1 = Math.toRadians(a.getLongitude());
	double lat2 = Math.toRadians(b.getLatitude());
	double lon2 = Math.toRadians(b.getLongitude());

	double dLat = lat2 - lat1;
	double dLon = lon2 - lon1;

	double x = Math.sin(dLat / 2) 
		* Math.sin(dLat / 2)
		+ Math.cos(lat1) 
		* Math.cos(lat2) 
		* Math.sin(dLon / 2) 
		* Math.sin(dLon / 2);

	double c = 2 * Math.atan2(Math.sqrt(x), Math.sqrt(1 - x));
	
	return 6371 * c; // Earth radius in km
    }
}