package com.designprinciples.librarycasestudy;

import java.util.HashMap;
import java.util.Map;

public class LibraryCatalog {
    private static LibraryCatalog instance;
    private final Map<String, Book> books = new HashMap<>();

    // private constructor
    private LibraryCatalog() {
    }

    public static LibraryCatalog getInstance() {
	if (instance == null) {
	    synchronized (LibraryCatalog.class) {
		if (instance == null) {
		    instance = new LibraryCatalog();
		}
	    }
	}
	return instance;
    }

    public void addBook(Book book) {
	books.put(book.getIsbn(), book);
	System.out.println("Added book: '" + book.getTitle() + "'");
    }

    public Book getBook(String isbn) {
	return books.get(isbn);
    }

    public void updateBookAvailability(String isbn, boolean available) {
	Book book = books.get(isbn);
	if (book != null) {
	    book.setAvailable(available);
	}
    }
}