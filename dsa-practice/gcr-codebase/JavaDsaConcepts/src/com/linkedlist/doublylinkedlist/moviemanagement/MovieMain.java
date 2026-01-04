package com.linkedlist.doublylinkedlist.moviemanagement;

public class MovieMain {
	public static void main(String[] args) {

		DoublyLinkedList head = null;  
        DoublyLinkedList list = new DoublyLinkedList("temp", "temp", 0, 0.0);

        head = list.addAtAnyPosition(head, 0);

        list.displayAllMovie(head);
        
        list.updateRating("1", head, 100);
        list.displayAllMovie(head);
        
	}
}
