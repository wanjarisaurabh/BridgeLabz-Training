import java.util.Scanner;

public class NumberCheck {

    // Method to check number
    public static int checkNumber(int n) {
        if (n > 0)
            return 1;
        else if (n < 0)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Result: " + checkNumber(n));
    }
}
