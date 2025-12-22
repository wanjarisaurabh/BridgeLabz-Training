import java.util.Scanner;

public class WordLength2DArray {

    // Method to find length without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            for (;;) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    // Method to split text into words using charAt()
    public static String[] customSplit(String text) {
        int length = findLength(text);

        // Step 1: Count words
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Step 2: Store space indexes
        int[] spaceIndexes = new int[wordCount - 1];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        // Step 3: Extract words
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < spaceIndexes.length; i++) {
            words[i] = text.substring(start, spaceIndexes[i]);
            start = spaceIndexes[i] + 1;
        }

        // Last word
        words[wordCount - 1] = text.substring(start, length);

        return words;
    }

    // Method to create 2D array of word and its length
    public static String[][] getWordLength2D(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];  // Word
            result[i][1] = String.valueOf(findLength(words[i])); // Length as String
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Split text
        String[] words = customSplit(input);

        // Create 2D array
        String[][] wordLength = getWordLength2D(words);

        // Display in tabular format
        System.out.println("\nWord\t\tLength");
        System.out.println("----------------------");

        for (int i = 0; i < wordLength.length; i++) {
            String word = wordLength[i][0];
            int length = Integer.parseInt(wordLength[i][1]); // Convert String to int

            System.out.println(word + "\t\t" + length);
        }

        sc.close();
    }
}
