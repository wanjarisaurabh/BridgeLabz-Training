/*
 * Program Name : LibraryBook
 * Description  : Represents a library book and allows
 *                borrowing if the book is available.
 */

package com.constructor.level1;

class LibraryBook {

    // Book details
    String title;
    String author;
    double price;
    boolean available;

    // Parameterized constructor
    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    // Method to borrow the book
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Sorry! Book is already borrowed.");
        }
    }

    // Method to display book status
    void display() {
        System.out.println("Title      : " + title);
        System.out.println("Available  : " + available);
    }
}
