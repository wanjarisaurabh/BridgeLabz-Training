package com.generics.smartwarehouse;

import java.util.List;

public class DisplayUtil {

	// Upper bounded wildcard - read-only access to any WarehouseItem subclass list
	public static void displayAllItems(List<? extends WarehouseItem> itemList) {
		if (itemList.isEmpty()) {
			System.out.println("  (No items in storage)");
			return;
		}
		System.out.println("  Stored items:");
		for (WarehouseItem item : itemList) {
			System.out.println("    - " + item);
		}
	}
}