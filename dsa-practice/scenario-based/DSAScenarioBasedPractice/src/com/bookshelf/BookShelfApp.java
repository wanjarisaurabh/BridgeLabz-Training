package com.bookshelf;

public class BookShelfApp {

    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(new Book(101, "Harry Potter", "J.K. Rowling", "Fantasy"));
        library.addBook(new Book(102, "The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        library.addBook(new Book(103, "Brief History of Time", "Stephen Hawking", "Science"));

        library.displayCatalog();

        library.removeBook(102);

        library.displayCatalog();
    }
}
