package com.generics.smartwarehouse;

import java.util.ArrayList;
import java.util.List;

public class Storage<T extends WarehouseItem> {
	private List<T> items = new ArrayList<>();

	// Adds an item (type-safe due to bounded T)
	public void addItem(T item) {
		items.add(item);
	}

	// Returns read-only view of items
	public List<T> getItems() {
		return items;
	}

	// Returns count of stored items
	public int getItemCount() {
		return items.size();
	}
}