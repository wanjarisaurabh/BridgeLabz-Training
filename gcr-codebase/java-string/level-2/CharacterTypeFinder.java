import java.util.Scanner;

public class CharacterTypeFinder {

    // Method to check character type using ASCII logic
    public static String checkCharacter(char ch) {

        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if character is a letter
        if (ch >= 'a' && ch <= 'z') {

            // Check vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to find character and its type using charAt()
    public static String[][] findCharacterTypes(String text) {

        // Find length without using length()
        int length = 0;
        try {
            for (;;) {
                text.charAt(length);
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // length found
        }

        String[][] result = new String[length][2];

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacter(ch);
        }

        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayTable(String[][] data) {

        System.out.println("\nCharacter\tType");
        System.out.println("---------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Process string
        String[][] result = findCharacterTypes(input);

        // Display result
        displayTable(result);

        sc.close();
    }
}
