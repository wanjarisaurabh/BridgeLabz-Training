package com.bookshelf;

import java.util.Objects;

public class Book{
	
private	String title;
private	String author;
private	String genre;
	private int bookId;
	
	public Book(
			int bookId,
			String title,
	String author,
	String genre) {
		this.title=title;
		this.author=author;
		this.genre=genre;
		this.bookId=bookId;
	}
	
	 public int getBookId() {
	        return bookId;
	    }

	    public String getGenre() {
	        return genre;
	    }
	    
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Book)) return false;
	        Book book = (Book) o;
	        return bookId == book.bookId;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(bookId);
	    }

	    @Override
	    public String toString() {
	        return "BookID: " + bookId +
	                ", Title: " + title +
	                ", Author: " + author;
	    }
}
