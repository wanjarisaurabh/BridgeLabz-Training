package com.smartcheckout;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayDeque;
//class to simulate the counter
public class Counter {
	//counter details
	
	int counterNumber;
	Queue<Customer> queue=new ArrayDeque<>();
	
	//customers
	public Counter(int counterNumber) {
		this.counterNumber=counterNumber;
	}
	
	//adding customer to the queue
	public void addCustomer(Customer cust) {
		queue.offer(cust);
	}
	
	// removing customer and handing on the bill
	public void removeCustomer() {
		if (queue.isEmpty()) {
	        System.out.println("The counter is empty!!!");
	        return;
	    }

	    Customer customer = queue.poll();

	    System.out.println("╔═════════════════════════════════╗");
	    System.out.println("║          YOUR BILL              ║");
	    System.out.println("╠═════════════════════════════════╣");
	    
	    double finalTotal=0;
	    for (Map.Entry<Integer, Integer> entry : customer.myCart.myCart.entrySet()) {
	        Item item = Store.getInfo(entry.getKey());
	        if (item == null) continue;

	        double total = item.price * entry.getValue();
	        finalTotal+=total;
	        System.out.printf("║ %-20s %-10.2f ║%n", item.name, total);
	    }
	    System.out.println("╠═════════════════════════════════╣");
	    System.out.printf("║ %-20s %-10.2f ║%n", "Total", finalTotal);
	    System.out.println("╚═════════════════════════════════╝");
	}
	
}
