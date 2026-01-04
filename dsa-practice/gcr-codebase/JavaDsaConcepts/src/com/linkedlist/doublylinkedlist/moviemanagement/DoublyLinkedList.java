package com.linkedlist.doublylinkedlist.moviemanagement;

import java.util.Scanner;

public class DoublyLinkedList {
	private String movieTitle;
	private String directorName;
	private int yearOfRelease;
	private double rating;
	DoublyLinkedList prev;
	DoublyLinkedList next;
	
	public DoublyLinkedList(String movieTitle, String directorName, int yearOfRelease, double rating) {
		this.prev = null;
		this.next = null;
		this.movieTitle = movieTitle;
		this.directorName = directorName;
		this.yearOfRelease = yearOfRelease;
		this.rating = rating;
	}
	
	public void displayMovie(DoublyLinkedList node) {
	    System.out.printf("%-20s %-20s %-15d %-10.1f%n",
	            node.movieTitle,
	            node.directorName,
	            node.yearOfRelease,
	            node.rating);
	}
	public void displayAllMovie(DoublyLinkedList head) {
	    if (head == null) {
	        System.out.println("No movies to display.");
	        return;
	    }

	    System.out.printf("%-20s %-20s %-15s %-10s%n",
	            "Movie Name", "Director Name", "Year", "Rating");
	    System.out.println("---------------------------------------------------------------");

	    DoublyLinkedList temp = head;
	    while (temp != null) {
	        displayMovie(temp);
	        temp = temp.next;  
	    }
	}
	public void updateRating(String movieTitle, DoublyLinkedList head, int rating) {
		if(head == null) {
			System.out.println("no movie uploaded");
			return;
		}
		DoublyLinkedList temp = head;
		while(temp != null) {
			if(temp.movieTitle.equals(movieTitle)) {
				temp.rating = rating;
				System.out.println("rating updated!");
				return;
			}
			temp = temp.next;
		}
		System.out.println("No movie found!");
		return;
	}
	
	public DoublyLinkedList create() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of movie");
		String movieTitle = input.next();
		System.out.println("Enter the name of director");
		String directorName = input.next();
		System.out.println("Enter the year of Release");
		int yearOfRelease= input.nextInt();
		System.out.println("Enter the rating of movie");
		double rating = input.nextDouble();
		
		DoublyLinkedList newNode = new DoublyLinkedList(movieTitle,directorName,yearOfRelease, rating);
		return newNode;
	}
	
	public DoublyLinkedList addAtBeginning(DoublyLinkedList head ) {
		
		DoublyLinkedList newNode = create();
		if(head == null) {
			head = newNode;
		}
		else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		return head;
	}
	public void displayAllMovieReverse(DoublyLinkedList head) {
	    if (head == null) {
	        System.out.println("No movies to display.");
	        return;
	    }
	    DoublyLinkedList temp = head;
	    while (temp.next != null) {
	        temp = temp.next;
	    }
	    System.out.printf("%-20s %-20s %-15s %-10s%n",
	            "Movie Name", "Director Name", "Year", "Rating");
	    System.out.println("---------------------------------------------------------------");
	    while (temp != null) {
	        displayMovie(temp);
	        temp = temp.prev;
	    }
	}

	public DoublyLinkedList addAtEnd(DoublyLinkedList head ) {
		
		DoublyLinkedList newNode = create();
		if(head == null) {
			head = newNode;
		}
		DoublyLinkedList temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.prev = temp; 
		return head;
	}
	
	public DoublyLinkedList addAtAnyPosition(DoublyLinkedList head, int position) {
	    DoublyLinkedList newNode = create();
	
	    if (head == null) {
	        return newNode;
	    }
	
	    if (position <= 1) {
	        newNode.next = head;
	        head.prev = newNode;
	        return newNode;
	    }
	
	    DoublyLinkedList temp = head;
	    int count = 1;
	
	    while (temp.next != null && count < position - 1) {
	        temp = temp.next;
	        count++;
	    }
	
	    newNode.next = temp.next;
	    newNode.prev = temp;
	
	    if (temp.next != null) {
	        temp.next.prev = newNode;
	    }
	
	    temp.next = newNode;
	
	    return head;
	}

}
