
import java.util.Scanner;

/*
 * Program Name : CharFrequencyUsingUnique
 * Description  : Finds frequency of characters using
 *                unique characters and charAt().
 */
public class CharFrequencyUsingUnique {

    // Method to find unique characters
    public static char[] findUniqueCharacters(String text) {

        char[] unique = new char[text.length()];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
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

    // Method to find frequency using unique characters
    public static void findFrequency(String text, char[] unique) {
        for (int i = 0; i < unique.length; i++) {
            if (unique[i] == '\0') {
                continue;
            }
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == unique[i]) {
                    count++;
                }
            }
            System.out.println(unique[i] + " : " + count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();
        char[] unique = findUniqueCharacters(text);
        findFrequency(text, unique);
        sc.close();
    }
}
