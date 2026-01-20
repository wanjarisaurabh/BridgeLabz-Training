/*
1. Smart Warehouse Management System
Concepts: Generic Classes, Bounded Type Parameters, Wildcards
Problem Statement:
	You are developing a Smart Warehouse System that manages different types of items like Electronics, Groceries, and Furniture. The system should be able to store and retrieve items dynamically while maintaining type safety.
Hints:
	Create an abstract class WarehouseItem that all items extend (Electronics, Groceries, Furniture).
	Implement a generic class Storage<T extends WarehouseItem> to store items safely.
	Implement a wildcard method to display all items in storage regardless of their type (List<? extends WarehouseItem>).

*/

package com.generics.smartwarehouse;

public class SmartWarehouseApp {

	public static void main(String[] args) {
		System.out.println("Smart Warehouse Management System\n");

		// Create type-specific storages (bounded generics ensure type safety)
		Storage<Electronics> electronicsStorage = new Storage<>();
		Storage<Groceries> groceriesStorage = new Storage<>();
		Storage<Furniture> furnitureStorage = new Storage<>();

		// Add items to respective storages
		electronicsStorage.addItem(new Electronics("Laptop", 999.99, "Dell"));
		electronicsStorage.addItem(new Electronics("Smartphone", 699.99, "Samsung"));

		groceriesStorage.addItem(new Groceries("Milk", 3.49, "2026-02-01"));
		groceriesStorage.addItem(new Groceries("Bread", 2.99, "2026-01-25"));

		furnitureStorage.addItem(new Furniture("Office Chair", 149.99, "Leather"));
		furnitureStorage.addItem(new Furniture("Desk", 299.99, "Wood"));

		// Display using wildcard method (works for any subclass list)
		System.out.println("Electronics Storage (" + electronicsStorage.getItemCount() + " items):");
		DisplayUtil.displayAllItems(electronicsStorage.getItems());

		System.out.println("\nGroceries Storage (" + groceriesStorage.getItemCount() + " items):");
		DisplayUtil.displayAllItems(groceriesStorage.getItems());

		System.out.println("\nFurniture Storage (" + furnitureStorage.getItemCount() + " items):");
		DisplayUtil.displayAllItems(furnitureStorage.getItems());

		// Type safety demonstration (these would cause compile errors)

		// electronicsStorage.addItem(new Groceries("Apple", 1.99, "2026-03-01"));
		// Compile error

		// Storage<String> invalidStorage = new Storage<>(); // Compile error - String
		// not extends WarehouseItem
	}
}
