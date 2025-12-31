package com.objectmodeling.assistedproblems.libraryaggregation;


public class Library {
    Book[] books;
    int count = 0;

    Library(int size) {
        books = new Book[size];
    }

    void addBook(Book book) {
        books[count++] = book;
    }
}
