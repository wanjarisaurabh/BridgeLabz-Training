
import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    // Generates StringIndexOutOfBoundsException
    static void createException(String text) {
        text.charAt(text.length());
    }

    // Handles the exception
    static void handleException(String text) {
        try {
            text.charAt(text.length());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled");
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
