import java.util.Scanner;

public class ToggleCase {

    // Method to toggle case of characters
    public static String toggleCase(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                result = result + (char)(ch + 32); // Convert to lowercase
            }
            else if (ch >= 'a' && ch <= 'z') {
                result = result + (char)(ch - 32); // Convert to uppercase
            }
            else {
                result = result + ch; // Keep as it is
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        String toggled = toggleCase(input);

        System.out.println("Toggled case string:");
        System.out.println(toggled);
    }
}
