/*
 * Program Name : EBook
 * Description  : Subclass accessing public and protected members.
 */

package com.constructor.level1;

class EBook extends Book {
    EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    void display() {
        System.out.println(ISBN + " | " + title + " | " + getAuthor());
    }
}
