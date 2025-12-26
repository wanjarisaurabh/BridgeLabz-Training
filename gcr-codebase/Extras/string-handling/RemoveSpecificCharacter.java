import java.util.Scanner;

public class RemoveSpecificCharacter {

    // Method to remove a specific character
    public static String removeCharacter(String text, char removeChar) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch != removeChar) {
                result = result + ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string:");
        String input = sc.nextLine();

        System.out.println("Enter the character to remove:");
        char removeChar = sc.next().charAt(0);

        String modifiedString = removeCharacter(input, removeChar);

        System.out.println("Modified String: \"" + modifiedString + "\"");
    }
}
