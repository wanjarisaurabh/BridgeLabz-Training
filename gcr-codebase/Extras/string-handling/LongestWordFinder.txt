import java.util.Scanner;

public class LongestWordFinder {

    // Method to find the longest word
    public static String findLongestWord(String sentence) {

        String[] words = sentence.split(" "); // Split sentence into words
        String longestWord = words[0];         // Assume first word is longest

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        String result = findLongestWord(sentence);

        System.out.println("Longest word: " + result);
    }
}
