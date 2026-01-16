package com.smartcheckout;
import java.util.HashMap;

//class to represent store 
public class Store {
	//hashmap to store the itemss
	private static HashMap<Integer,Item> products=new HashMap<>();
	
	//method to get the info about the item
	public static Item getInfo(int itemId) {
		if(!products.containsKey(itemId)) {
			System.out.println("The product with id "+itemId+" does not exist");
			return null;	
		}
		
		return products.get(itemId);
	}
	
	//adding the products
	public static void addOrIncreaseItem(int itemId,String name,double price,int availableQuantity) {
		
		if(products.containsKey(itemId)){
			System.out.println("Item with id "+itemId+" already exists we will increase the quantity");
			products.get(itemId).availableQuantity+=availableQuantity;
			return;
		}
		Item itm=new Item(itemId,name,price,availableQuantity);
		products.put(itemId, itm);
	}
	
	//removing the product
	public static void removeItem(int itemId) {
		if(!products.containsKey(itemId)) {
			System.out.println("The product with id "+itemId+" does not exist");
			return;	
		}
		
		products.remove(itemId);
	}
	
	//purchase logic
	public static boolean purchaseItem(int itemId,int quantity) {
		if(!products.containsKey(itemId)) {
			System.out.println("The product with id "+itemId+" does not exist");
			return false;	
		}
		if(products.get(itemId).availableQuantity<=0 || (products.get(itemId).availableQuantity-quantity)<0) {
			System.out.println("The required quantity is not avalibale");
			return false;
		}
		int curQuan=products.get(itemId).availableQuantity;
		products.get(itemId).availableQuantity=curQuan-quantity;
		return true;
		
		
	}
	
	//showinfg all items
	public static void showItems() {
        System.out.println("\n===== STORE ITEMS =====");
        System.out.println("ID\tName\t\tPrice\tStock");

        for (Item item : products.values()) {
            System.out.printf("%d\t%-10s\t%.2f\t%d%n",
                    item.itemId,
                    item.name,
                    item.price,
                    item.availableQuantity);
        }
    }
	
	
	
}
