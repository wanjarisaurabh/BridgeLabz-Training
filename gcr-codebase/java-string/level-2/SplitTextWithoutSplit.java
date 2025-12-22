import java.util.Scanner;

public class SplitTextWithoutSplit {

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

    // Method to split text into words without using split()
    public static String[] customSplit(String text) {
        int length = findLength(text);

        // Step 1: Count number of words
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

        // Step 3: Extract words using indexes
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

    // Method to compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Custom split
        String[] customResult = customSplit(input);

        // Built-in split
        String[] builtInResult = input.split(" ");

        // Compare results
        boolean isSame = compareArrays(customResult, builtInResult);

        // Display results
        System.out.println("\nCustom Split Result:");
        for (String word : customResult) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in split() Result:");
        for (String word : builtInResult) {
            System.out.println(word);
        }

        System.out.println("\nAre both results same? " + isSame);

        sc.close();
    }
}
