package com.smartcheckout;

//customer class
public class Customer {
	String name;
	//cart object for cart
	Cart myCart=new Cart();
	
	public Customer(String name) {
		this.name=name;
		
	}
	
	// the purchasing logic
	public void getItem(int itemId,int quantity) {
		if(Store.purchaseItem(itemId,quantity)) {
			myCart.addOrIncreaseToCart(itemId, quantity);
			System.out.println("Purchase sucessfull");
			return;
		}
		System.out.println("Purchase unsuccesfull");	
	}
	
}
