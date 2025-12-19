// Program to find largest and second largest digit
import java.util.Scanner;

public class LargestSecondLargestDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] digits = new int[10];
        int index = 0;

        // Storing digits up to array limit
        while (number != 0 && index < 10) {
            digits[index++] = number % 10;
            number /= 10;
        }

        int largest = 0, secondLargest = 0;

        // Finding largest and second largest digit
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest = " + largest);
        System.out.println("Second Largest = " + secondLargest);

        sc.close();
    }
}
