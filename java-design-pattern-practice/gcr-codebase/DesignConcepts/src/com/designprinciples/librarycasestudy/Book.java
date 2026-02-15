package com.designprinciples.librarycasestudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private final String isbn;
    private final String title;
    private final List<String> authors;
    private final int edition;
    private final String publisher;
    private final String genre;
    private boolean available;

    private final List<User> observers = new ArrayList<>();

    // Private constructor - only Builder can create instance
    private Book(BookBuilder builder) {
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.authors = builder.authors;
        this.edition = builder.edition;
        this.publisher = builder.publisher;
        this.genre = builder.genre;
        this.available = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        if (this.available == available) {
            return;
        }
        this.available = available;
        if (available) {
            // Only notify all, when the book becomes available
            notifyObservers("Book '" + title + "' is now available!");
        } else {
            // Only notify librarians, when book is unavailable
            notifyLibrarians("Book '" + title + "' is now available!");            
        }
    }
    
    // Observer pattern methods
    public void attach(User observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void detach(User observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (User observer : observers) {
            observer.update(message);
        }
    }
    
    public void notifyLibrarians(String message) {
        for (User observer : observers) {
            if(observer.getRole().equals("Librarian")) {        	
        	observer.update(message);
            }
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", edition=" + edition +
                ", publisher='" + publisher + '\'' +
                ", genre='" + genre + '\'' +
                ", available=" + available +
                '}';
    }

    // Static nested Builder class
    public static class BookBuilder {
        private String isbn;
        private String title;
        private List<String> authors = new ArrayList<>();
        private int edition = 1;
        private String publisher = "Unknown";
        private String genre = "General";

        public BookBuilder(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }

        public BookBuilder withAuthors(String... authors) {
            this.authors.addAll(Arrays.asList(authors));
            return this;
        }

        public BookBuilder withEdition(int edition) {
            this.edition = edition;
            return this;
        }

        public BookBuilder withPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public BookBuilder withGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}