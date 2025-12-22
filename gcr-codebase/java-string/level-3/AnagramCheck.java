
import java.util.Scanner;

/*
 * Program Name : AnagramCheck
 * Description  : Checks whether two strings are anagrams
 *                using character frequency comparison.
 */
public class AnagramCheck {

    // Method to check anagram
    public static boolean isAnagram(String s1, String s2) {

        // If lengths are not equal, not anagram
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        // Store frequency of characters of first string
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i)]++;
        }

        // Store frequency of characters of second string
        for (int i = 0; i < s2.length(); i++) {
            freq2[s2.charAt(i)]++;
        }
        // Compare both frequency arrays
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();
        if (isAnagram(s1, s2)) {
            System.out.println("Strings are Anagrams"); 
        }else {
            System.out.println("Strings are NOT Anagrams");
        }
        sc.close();
    }
}
