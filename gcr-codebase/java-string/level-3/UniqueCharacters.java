
import java.util.Scanner;

/*
 * Program Name : UniqueCharacters
 * Description  : Finds unique characters in a string
 *                using charAt() and nested loops.
 */
public class UniqueCharacters {

    // Method to find length of string without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // loop stops when index goes out of range
        }
        return count;
    }

    // Method to find unique characters
    public static char[] findUniqueCharacters(String text) {

        int length = findLength(text);
        char[] unique = new char[length];
        int index = 0;

        for (int i = 0; i < length; i++) {

            char ch = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[index++] = ch;
            }
        }
        return unique;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        char[] result = findUniqueCharacters(text);
        System.out.print("Unique characters are: ");
        for (int i = 0; i < result.length; i++) {
            if (result[i] != '\0') {
                System.out.print(result[i] + " ");
            }
        }
        sc.close();
    }
}
