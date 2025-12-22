
import java.util.Scanner;

public class NumberFormatDemo {

    // Generates NumberFormatException
    static void createException(String text) {
        Integer.parseInt(text);
    }

    // Handles NumberFormatException
    static void handleException(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number in string form: ");
        String text = sc.next();
        try {
            createException(text);
        } catch (Exception e) {
            handleException(text);
        }
    }
}
