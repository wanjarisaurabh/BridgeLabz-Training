
import java.util.Scanner;

public class UpperCaseConversion {

    // Convert lowercase letters to uppercase using ASCII values
    static String toUpper(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                result += (char) (ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String userUpper = toUpper(text);
        String builtInUpper = text.toUpperCase();
        System.out.println("User-defined result: " + userUpper);
        System.out.println("Built-in result: " + builtInUpper);
        System.out.println("Both are same: " + userUpper.equals(builtInUpper));
    }
}
