import java.util.Scanner;

public class MostFrequentCharacter {

    // Method to find most frequent character
    public static char findMostFrequentChar(String text) {

        int[] freq = new int[256]; // ASCII characters

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        int maxCount = 0;
        char mostFrequent = text.charAt(0);

        // Find character with maximum frequency
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] > maxCount) {
                maxCount = freq[ch];
                mostFrequent = ch;
            }
        }

        return mostFrequent;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        char result = findMostFrequentChar(input);

        System.out.println("Most Frequent Character: '" + result + "'");
    }
}
