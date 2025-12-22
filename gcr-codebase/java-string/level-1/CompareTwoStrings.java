
import java.util.Scanner;

public class CompareTwoStrings {

    // This method compares two strings without using equals()
    static boolean compareStrings(String s1, String s2) {
        // If lengths are different, strings are not equal
        if (s1.length() != s2.length()) {
            return false;
        }
        // Compare characters one by one
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = sc.next();
        System.out.print("Enter second string: ");
        String str2 = sc.next();
        boolean userResult = compareStrings(str1, str2);
        boolean builtInResult = str1.equals(str2);
        System.out.println("Result using charAt(): " + userResult);
        System.out.println("Result using equals(): " + builtInResult);
    }
}
