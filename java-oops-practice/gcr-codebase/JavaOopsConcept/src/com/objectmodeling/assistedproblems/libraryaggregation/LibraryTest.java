package com.objectmodeling.assistedproblems.libraryaggregation;



public class LibraryTest {
    public static void main(String[] args) {
        Book b1 = new Book("Java", "James");
        Library lib = new Library(5);
        lib.addBook(b1);
    }
}
