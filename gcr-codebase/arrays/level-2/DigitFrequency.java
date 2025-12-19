// Program to find frequency of each digit
import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] freq = new int[10];

        // Counting frequency of digits
        while (number != 0) {
            freq[number % 10]++;
            number /= 10;
        }

        // Displaying digit frequency
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0)
                System.out.println(i + " occurs " + freq[i] + " times");
        }

        sc.close();
    }
}
