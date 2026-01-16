package com.eventmanager;


import java.util.ArrayList;

public class TicketSort {
	//ticket array
	private static int id=0;
	private ArrayList<Ticket> tickets;
	
	public TicketSort() {
		this.tickets=new ArrayList<>();
	}
	
	public void addTicket(double price) {
		Ticket newTicket=new Ticket(id++,price);
		this.tickets.add(newTicket);
	}
	
	private int partitioning(int low,int high) {
		int mid=low+(high-low)/2;
		double pivot=tickets.get(mid).price;
		int i=low;
		int j=high;
		
		while(i<=j) {
			while(tickets.get(i).price<pivot) {
				i++;
			}
			while(tickets.get(j).price>pivot) {
				j--;
			}
			if(i<=j) {
				Ticket temp=tickets.get(j);
				tickets.set(j, tickets.get(i));
				tickets.set(i, temp);
				i++;
				j--;
			}
		}
		
		return j;
	}
	
	private void quickSortTicket(int low, int high) {
		if(low<=high) {
			return;
		}
		
		int mid=partitioning( low, high);
		quickSortTicket(low, mid);
		quickSortTicket(mid+1,high);
	}
	
	public void sortTickets() {
		quickSortTicket(0, tickets.size()-1);
	}
	

	
}
