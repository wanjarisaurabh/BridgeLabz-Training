import java.util.Scanner;

public class ReverseString {

    // Method to reverse a string
    public static String reverseString(String text) {
        String reversed = "";

        // Loop from last character to first
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = reverseString(input);

        System.out.println("Reversed string: " + result);

        sc.close();
    }
}
