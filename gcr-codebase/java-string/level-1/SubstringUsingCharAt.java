
import java.util.Scanner;

public class SubstringUsingCharAt {

    // This method creates substring using charAt()
    static String makeSubstring(String text, int start, int end) {
        String sub = "";
        for (int i = start; i < end; i++) {
            sub = sub + text.charAt(i);
        }
        return sub;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();
        String userSub = makeSubstring(text, start, end);
        String builtInSub = text.substring(start, end);
        System.out.println("User-defined substring: " + userSub);
        System.out.println("Built-in substring: " + builtInSub);
        System.out.println("Both substrings same: " + userSub.equals(builtInSub));
    }
}
