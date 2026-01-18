package com.cropmonitor;

public class SensorData {
	String location;
	double temperature;
	String timestamp;
	
	// constructor
	public SensorData(String location, double temperature, String timestamp) {
		this.location = location;
		this.temperature = temperature;
		this.timestamp = timestamp;
	}
	
	// convert timestamp to comparable format
	private static long timeToSeconds(String time) {
		String[] parts = time.split(":");
		return Long.parseLong(parts[0]) * 3600 + Long.parseLong(parts[1]) * 60 + Long.parseLong(parts[2]);
	}
	
	// partition for quick sort
	private static int partition(SensorData[] data, int low, int high) {
		String pivot = data[high].timestamp;
		int i = low - 1;
		
		for (int j = low; j < high; j++) {
			if (timeToSeconds(data[j].timestamp) <= timeToSeconds(pivot)) {
				i++;
				// swap
				SensorData temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		}
		
		// place pivot in correct position
		SensorData temp = data[i + 1];
		data[i + 1] = data[high];
		data[high] = temp;
		
		return i + 1;
	}
	
	// quick sort
	private static void quickSort(SensorData[] data, int low, int high) {
		if (low < high) {
			int pi = partition(data, low, high);
			
			quickSort(data, low, pi - 1);
			quickSort(data, pi + 1, high);
		}
	}
	
	// sort sensor data
	public static void sortData(SensorData[] data) {
		quickSort(data, 0, data.length - 1);
	}
}
