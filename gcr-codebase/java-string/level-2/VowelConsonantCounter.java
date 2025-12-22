import java.util.Scanner;

public class VowelConsonantCounter {

    // Method to check if a character is Vowel, Consonant, or Not a Letter
    public static String checkCharacter(char ch) {

        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if character is a letter
        if (ch >= 'a' && ch <= 'z') {

            // Check for vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' || 
                ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to count vowels and consonants using charAt()
    public static int[] findVowelsAndConsonants(String text) {

        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; ; i++) {
            try {
                char ch = text.charAt(i);
                String result = checkCharacter(ch);

                if (result.equals("Vowel")) {
                    vowelCount++;
                } else if (result.equals("Consonant")) {
                    consonantCount++;
                }
            } catch (StringIndexOutOfBoundsException e) {
                break; // End of string reached
            }
        }

        return new int[] { vowelCount, consonantCount };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Call method
        int[] counts = findVowelsAndConsonants(input);

        // Display result
        System.out.println("\nVowels Count     : " + counts[0]);
        System.out.println("Consonants Count : " + counts[1]);

        sc.close();
    }
}
