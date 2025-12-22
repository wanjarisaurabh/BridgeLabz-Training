import java.util.Scanner;

public class CustomTrimString {

    // Method to find start and end index after trimming spaces
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = 0;

        // Find length without using length()
        try {
            for (;;) {
                text.charAt(end);
                end++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            end = end - 1; // last valid index
        }

        // Trim leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[] { start, end };
    }

    // Method to create substring using charAt()
    public static String customSubstring(String text, int start, int end) {
        String result = "";

        for (int i = start; i <= end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {

        int i = 0;
        try {
            for (;;) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return false;
                }
                i++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Check if both strings ended at same time
            try {
                s1.charAt(i);
                return false;
            } catch (StringIndexOutOfBoundsException ex1) {
                try {
                    s2.charAt(i);
                    return false;
                } catch (StringIndexOutOfBoundsException ex2) {
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();

        // Custom trim logic
        int[] indexes = findTrimIndexes(input);
        String customTrimmed = customSubstring(input, indexes[0], indexes[1]);

        // Built-in trim
        String builtInTrimmed = input.trim();

        // Compare both results
        boolean isSame = compareStrings(customTrimmed, builtInTrimmed);

        // Display result
        System.out.println("\nCustom Trim Result   : \"" + customTrimmed + "\"");
        System.out.println("Built-in Trim Result : \"" + builtInTrimmed + "\"");
        System.out.println("Are both strings same? " + isSame);

        sc.close();
    }
}
