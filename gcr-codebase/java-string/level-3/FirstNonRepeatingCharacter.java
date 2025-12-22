
import java.util.Scanner;

/*
 * Program Name : FirstNonRepeatingCharacter
 * Description  : Finds the first non-repeating character
 *                in a string using charAt() and ASCII array.
 */
public class FirstNonRepeatingCharacter {

    // Method to find first non-repeating character
    public static char findFirstNonRepeatingChar(String text) {

        // ASCII frequency array (256 characters)
        int[] freq = new int[256];

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }
        return '\0'; // if no non-repeating character found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        char result = findFirstNonRepeatingChar(text);
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result); 
        }else {
            System.out.println("No non-repeating character found");
        }
        sc.close();
    }
}
