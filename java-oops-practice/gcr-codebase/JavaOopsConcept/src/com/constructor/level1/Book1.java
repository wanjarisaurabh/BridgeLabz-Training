/*
 * Program Name : Book
 * Description  : Demonstrates default and parameterized constructors
 *                to initialize book details.
 */
class Book1 {

    // Instance variables to store book details
    String title;
    String author;
    double price;

    // Default constructor to initialize default values
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor to initialize user-defined values
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void display() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : ₹" + price);
    }
}
