package com.robowarehouse;

public class Package {
	String name;
	double weight;
	
	// constructor
	public Package(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	// insertion sort - adds package in sorted order
	public static void loadShelf(Package[] shelf, int n) {
		for (int i = 1; i < n; i++) {
			Package current = shelf[i];
			int j = i - 1;
			
			// shift heavier packages to right
			while (j >= 0 && shelf[j].weight > current.weight) {
				shelf[j + 1] = shelf[j];
				j--;
			}
			
			shelf[j + 1] = current;
		}
	}
}
