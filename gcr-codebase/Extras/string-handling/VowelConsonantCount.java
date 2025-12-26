import java.util.Scanner;

public class VowelConsonantCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        int vowels = 0;
        int consonants = 0;

        // make comparison easy
        text = text.toLowerCase(); 
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check only alphabets
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                    ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels count     : " + vowels);
        System.out.println("Consonants count : " + consonants);

        sc.close();
    }
}
