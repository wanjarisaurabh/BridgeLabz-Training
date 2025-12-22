import java.util.Scanner;

public class ShortestAndLongestWord {

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
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    // Method to find shortest and longest word indexes
    public static int[] findShortestAndLongest(String[][] wordLength) {
        int minIndex = 0;
        int maxIndex = 0;

        int minLength = Integer.parseInt(wordLength[0][1]);
        int maxLength = Integer.parseInt(wordLength[0][1]);

        for (int i = 1; i < wordLength.length; i++) {
            int currentLength = Integer.parseInt(wordLength[i][1]);

            if (currentLength < minLength) {
                minLength = currentLength;
                minIndex = i;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxIndex = i;
            }
        }

        return new int[] { minIndex, maxIndex };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Split words
        String[] words = customSplit(input);

        // Create 2D array (word, length)
        String[][] wordLength = getWordLength2D(words);

        // Find shortest and longest
        int[] resultIndexes = findShortestAndLongest(wordLength);

        // Display results
        System.out.println("\nWord\t\tLength");
        System.out.println("----------------------");
        for (int i = 0; i < wordLength.length; i++) {
            System.out.println(
                wordLength[i][0] + "\t\t" +
                Integer.parseInt(wordLength[i][1])
            );
        }

        System.out.println("\nShortest Word: " + wordLength[resultIndexes[0]][0]);
        System.out.println("Longest Word : " + wordLength[resultIndexes[1]][0]);

        sc.close();
    }
}
