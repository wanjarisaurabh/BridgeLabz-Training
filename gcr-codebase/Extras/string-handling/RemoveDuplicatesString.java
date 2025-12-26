import java.util.Scanner;

public class RemoveDuplicatesString {

    // Method to remove duplicate characters
    public static String removeDuplicates(String text) {
        String result = "";

        // Outer loop: pick each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean isDuplicate = false;

            // Inner loop: check if character already exists in result
            for (int j = 0; j < result.length(); j++) {
                if (ch == result.charAt(j)) {
                    isDuplicate = true;
                    break;
                }
            }

            // Add character if it is not a duplicate
            if (!isDuplicate) {
                result = result + ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String output = removeDuplicates(input);

        System.out.println("String after removing duplicates: " + output);

        sc.close();
    }
}
