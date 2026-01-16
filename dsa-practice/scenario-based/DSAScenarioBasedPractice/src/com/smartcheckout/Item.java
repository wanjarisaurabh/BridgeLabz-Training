package com.smartcheckout;


//item class to represent every item
public class Item {
	//item details
	int itemId;
	String name;
	double price;
	int availableQuantity;
	
	
	public Item(int itemId, String name, double price,int availableQuantity ){
		this.name=name;
		this.price=price;
		this.availableQuantity=availableQuantity;
		this.itemId=itemId;
		
	}
}
