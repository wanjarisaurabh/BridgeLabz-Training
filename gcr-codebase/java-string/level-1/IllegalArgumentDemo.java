
import java.util.Scanner;

public class IllegalArgumentDemo {

    // Generates IllegalArgumentException
    static void createException(String text) {
        text.substring(5, 2);
    }

    // Handles IllegalArgumentException
    static void handleException(String text) {
        try {
            text.substring(5, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.next();
        try {
            createException(text);
        } catch (Exception e) {
            handleException(text);
        }
    }
}
