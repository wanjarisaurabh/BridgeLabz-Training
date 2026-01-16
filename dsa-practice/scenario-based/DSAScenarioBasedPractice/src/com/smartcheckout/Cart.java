package com.smartcheckout;

import java.util.HashMap;
//class to work as cart for customer
public class Cart {
//hashmap to work as a cart
	
	HashMap<Integer,Integer> myCart=new HashMap<>();
	
	
	public void addOrIncreaseToCart(int itemId,int quantity) {
		
		if (quantity <= 0) {
	        System.out.println("Invalid quantity: " + quantity);
	        return;
	    }

	    if (myCart.containsKey(itemId)) {
	        myCart.put(itemId, myCart.get(itemId) + quantity);
	    } else {
	        myCart.put(itemId, quantity);
	    }
	}
	
	
}
