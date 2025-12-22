
import java.util.Scanner;

/*
 * Program Name : CharFrequency
 * Description  : Finds frequency of characters in a string
 *                using charAt() and ASCII values.
 */
public class CharFrequency {
    // Method to find frequency of characters
    public static int[] findFrequency(String text) {

        int[] freq = new int[256]; // ASCII size

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }
        return freq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        int[] freq = findFrequency(text);
        System.out.println("Character Frequencies:");
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                System.out.println((char) i + " : " + freq[i]);
            }
        }
        sc.close();
    }
}
