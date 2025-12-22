
import java.util.Scanner;

public class LowerCaseConversion {

    // Convert uppercase letters to lowercase using ASCII values
    static String toLower(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String userLower = toLower(text);
        String builtInLower = text.toLowerCase();
        System.out.println("User-defined result: " + userLower);
        System.out.println("Built-in result: " + builtInLower);
        System.out.println("Both are same: " + userLower.equals(builtInLower));
    }
}
