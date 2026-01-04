package com.linkedlist.singlylinkedlist.inventorymanagement;

public class InventoryMain {
    public static void main(String[] args) {

        Inventory inv = new Inventory();

        inv.addAtEnd(101, "Laptop", 5, 55000);
        inv.addAtEnd(102, "Mouse", 20, 500);
        inv.addAtBeginning(103, "Keyboard", 10, 1200);
        inv.addAtPosition(2, 104, "Monitor", 7, 15000);
        System.out.println("Inventory List:");
        inv.displayInventory();

        System.out.println("\nSearch by ID:");
        inv.searchById(102);
        System.out.println("\nUpdate Quantity:");
        inv.updateQuantity(101, 8);

        System.out.println("\nTotal Inventory Value:");
        inv.calculateTotalValue();
        System.out.println("\nSort by Name (Ascending):");
        inv.sortByName(true);
        inv.displayInventory();

        System.out.println("\nSort by Price (Descending):");
        inv.sortByPrice(false);
        inv.displayInventory();
        
        System.out.println("\nRemove Item:");
        inv.removeById(103);
        inv.displayInventory();
    }
}