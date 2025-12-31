package com.objectmodeling.assistedproblems.libraryaggregation;

public class Book {
    String title, author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void displayBook() {
        System.out.println(title + " by " + author);
    }
}
