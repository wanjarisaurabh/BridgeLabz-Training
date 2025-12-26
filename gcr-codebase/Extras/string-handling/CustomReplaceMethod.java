import java.util.Scanner;

public class CustomReplaceMethod {

    // Method to replace a word in a sentence
    public static String replaceWord(String sentence, String oldWord, String newWord) {

        String result = "";
        String currentWord = "";

        for (int i = 0; i < sentence.length(); i++) {

            char ch = sentence.charAt(i);

            if (ch != ' ') {
                currentWord = currentWord + ch;
            } else {
                if (currentWord.equals(oldWord)) {
                    result = result + newWord + " ";
                } else {
                    result = result + currentWord + " ";
                }
                currentWord = "";
            }
        }

        // Check last word
        if (currentWord.equals(oldWord)) {
            result = result + newWord;
        } else {
            result = result + currentWord;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the sentence:");
        String sentence = sc.nextLine();

        System.out.println("Enter the word to replace:");
        String oldWord = sc.next();

        System.out.println("Enter the new word:");
        String newWord = sc.next();

        String modifiedSentence = replaceWord(sentence, oldWord, newWord);

        System.out.println("Modified Sentence:");
        System.out.println(modifiedSentence);
    }
}
