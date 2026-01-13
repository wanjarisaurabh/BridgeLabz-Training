package com.bookshelf;

import java.util.*;

public class Library {

    // Genre → List of Books
    private Map<String, LinkedList<Book>> catalog = new HashMap<>();

    // To avoid duplicate books
    private Set<Integer> bookIds = new HashSet<>();

    /* -------- ADD BOOK (Return Book) -------- */
    public void addBook(Book book) {

        if (bookIds.contains(book.getBookId())) {
            System.out.println("Duplicate book not allowed!");
            return;
        }

        catalog.putIfAbsent(book.getGenre(), new LinkedList<>());
        catalog.get(book.getGenre()).add(book);
        bookIds.add(book.getBookId());

        System.out.println("Book added successfully.");
    }

    /* -------- REMOVE BOOK (Borrow Book) -------- */
    public void removeBook(int bookId) {

        for (LinkedList<Book> books : catalog.values()) {
            Iterator<Book> iterator = books.iterator();

            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.getBookId() == bookId) {
                    iterator.remove();
                    bookIds.remove(bookId);
                    System.out.println("Book removed successfully.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    /* -------- DISPLAY CATALOG -------- */
    public void displayCatalog() {

        if (catalog.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }

        for (Map.Entry<String, LinkedList<Book>> entry : catalog.entrySet()) {
            System.out.println("\nGenre: " + entry.getKey());
            for (Book book : entry.getValue()) {
                System.out.println("  " + book);
            }
        }
    }
}
