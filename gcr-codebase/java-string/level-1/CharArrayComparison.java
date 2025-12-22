
import java.util.Scanner;

public class CharArrayComparison {

    // Convert string to character array manually
    static char[] convertToCharArray(String text) {
        char[] arr = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i);
        }
        return arr;
    }

    // Compare two character arrays
    static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.next();
        char[] userArray = convertToCharArray(text);
        char[] builtInArray = text.toCharArray();
        System.out.println("Both arrays are equal: " +
                compareArrays(userArray, builtInArray));
    }
}
