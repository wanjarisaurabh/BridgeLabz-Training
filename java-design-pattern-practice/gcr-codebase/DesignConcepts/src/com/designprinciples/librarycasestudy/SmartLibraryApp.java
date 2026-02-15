package com.designprinciples.librarycasestudy;

public class SmartLibraryApp {

    public static void main(String[] args) {
	System.out.println("====================================================================================");
	System.out.println("		SMART UNIVERSITY LIBRARY MANAGEMENT SYSTEM");
	System.out.println("====================================================================================\n");
	
        // Get the singleton catalog
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        // Create books using Builder pattern
        Book dsBook = new Book.BookBuilder("978-0262033848", "Introduction to Algorithms")
                .withAuthors("Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein")
                .withEdition(3)
                .withPublisher("MIT Press")
                .withGenre("Computer Science")
                .build();

        Book javaBook = new Book.BookBuilder("978-0134685991", "Effective Java")
                .withAuthors("Joshua Bloch")
                .withEdition(3)
                .withPublisher("Addison-Wesley")
                .withGenre("Programming")
                .build();

        catalog.addBook(dsBook);
        catalog.addBook(javaBook);

        // Create users using Factory pattern
        User alice = UserFactory.createUser("Alice", "Student");
        User bob = UserFactory.createUser("Bob", "Faculty");
        User librarian1 = UserFactory.createUser("Dr. Sharma", "Librarian");
        User librarian2 = UserFactory.createUser("Dr. Verma", "Librarian");

        // Subscribe to notifications (Observer pattern)
        dsBook.attach(alice);
        dsBook.attach(bob);

        // Librarian one subscribed
        dsBook.attach(librarian1);

        System.out.println("\n--> Someone borrowed 'Introduction to Algorithms' (Subscribed librarian notified)");
        catalog.updateBookAvailability("978-0262033848", false);

        System.out.println("\n--> Book returned (All subscribers notified)");
        catalog.updateBookAvailability("978-0262033848", true);

        // Librarian two subscribed later
        dsBook.attach(librarian2);

        System.out.println("\n--> Book borrowed again (Subscribed librarians notified)");
        catalog.updateBookAvailability("978-0262033848", false);
        
	System.out.println("\n====================================================================================");
	System.out.println("		  THANKS FOR VISITING, HAPPY LEARNING!");
	System.out.println("====================================================================================");

    }
}