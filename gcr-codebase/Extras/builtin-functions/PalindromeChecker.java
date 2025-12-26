
import java.util.Scanner;

/*
 * Program Name : PalindromeChecker
 *
 * Description :
 * A palindrome is a string that reads the same
 * forward and backward.
 * This program checks whether a given string
 * is a palindrome.
 */
public class PalindromeChecker {

    // Checks if the given string is a palindrome
    public static boolean isPalindrome(String text) {

        // Remove spaces and convert to lowercase
        text = text.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = text.length() - 1;

        // Compare characters from both ends
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read string input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Display result
        if (isPalindrome(input)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        sc.close();
    }
}
