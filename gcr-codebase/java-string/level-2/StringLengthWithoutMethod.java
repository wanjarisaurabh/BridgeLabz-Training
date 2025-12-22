import java.util.Scanner;

public class StringLengthWithoutMethod {

    // User-defined method to find string length
    public static int findLength(String str) {
        int count = 0;

        try {
            // Infinite loop
            for (;;) {
                str.charAt(count); // Access character
                count++;           // Increase count
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception occurs when index exceeds string length
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String input = sc.next();   // using next() as per hint

        // Calling user-defined method
        int customLength = findLength(input);

        // Using built-in length() method
        int builtInLength = input.length();

        // Display results
        System.out.println("Length using user-defined method: " + customLength);
        System.out.println("Length using built-in length() method: " + builtInLength);

        sc.close();
    }
}
