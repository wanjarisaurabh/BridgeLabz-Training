import java.util.Scanner;

public class AnagramCheck {

    // Method to check if two strings are anagrams
    public static boolean areAnagrams(String s1, String s2) {

        // Remove spaces (optional)
        s1 = s1.replace(" ", "");
        s2 = s2.replace(" ", "");

        // Check length
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] freq = new int[256]; // ASCII characters

        // Count characters of first string
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
        }

        // Reduce count using second string
        for (int i = 0; i < s2.length(); i++) {
            freq[s2.charAt(i)]--;
        }

        // Check if all counts are zero
        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string:");
        String str1 = sc.nextLine();

        System.out.println("Enter second string:");
        String str2 = sc.nextLine();

        if (areAnagrams(str1, str2)) {
            System.out.println("The strings are anagrams");
        } else {
            System.out.println("The strings are NOT anagrams");
        }
    }
}
