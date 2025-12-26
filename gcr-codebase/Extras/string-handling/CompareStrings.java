import java.util.Scanner;

public class CompareStrings {

    // Method to compare two strings lexicographically
    public static void compareStrings(String s1, String s2) {

        int minLength = (s1.length() < s2.length()) ? s1.length() : s2.length();

        for (int i = 0; i < minLength; i++) {

            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 < c2) {
                System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
                return;
            }
            else if (c1 > c2) {
                System.out.println("\"" + s1 + "\" comes after \"" + s2 + "\" in lexicographical order");
                return;
            }
        }

        // If all characters are same till now
        if (s1.length() < s2.length()) {
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
        }
        else if (s1.length() > s2.length()) {
            System.out.println("\"" + s1 + "\" comes after \"" + s2 + "\" in lexicographical order");
        }
        else {
            System.out.println("Both strings are equal");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string:");
        String str1 = sc.nextLine();

        System.out.println("Enter second string:");
        String str2 = sc.nextLine();

        compareStrings(str1, str2);
    }
}
