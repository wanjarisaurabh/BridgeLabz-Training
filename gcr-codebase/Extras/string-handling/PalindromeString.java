import java.util.Scanner;

public class PalindromeString {

    // Method to check palindrome
    public static boolean isPalindrome(String text) {
        String reverse = "";

        // Reverse the string manually
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse = reverse + text.charAt(i);
        }

        // Compare original and reversed string
        return text.equals(reverse);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The string is a Palindrome");
        } else {
            System.out.println("The string is NOT a Palindrome");
        }

        sc.close();
    }
}
