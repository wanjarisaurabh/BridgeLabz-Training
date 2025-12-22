
import java.util.Scanner;

/*
 * Program Name : CharFrequencyUsingNestedLoops
 * Description  : Finds frequency of characters in a string
 *                using nested loops and charAt().
 */
public class CharFrequencyUsingNestedLoops {

    // Method to find characters and their frequencies
    public static String[] findFrequency(String text) {
        char[] chars = text.toCharArray();   // store characters
        int[] freq = new int[chars.length];  // store frequency
        // Calculate frequency using nested loops
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '0') {
                continue;
            }

            freq[i] = 1;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark duplicate
                }
            }
        }

        // Store characters and frequencies in String array
        String[] result = new String[chars.length];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index++] = chars[i] + " : " + freq[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        String[] result = findFrequency(text);
        System.out.println("Character Frequencies:");
        for (int i = 0; i < result.length; i++) {
            if (result[i] != null) {
                System.out.println(result[i]);
            }
        }
        sc.close();
    }
}
