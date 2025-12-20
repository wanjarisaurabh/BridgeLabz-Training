import java.util.Scanner;

public class AthleteRounds {

    // Method to calculate rounds
    public static double calculateRounds(double a, double b, double c) {
        return 5000 / (a + b + c);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side 1: ");
        double a = sc.nextDouble();
        System.out.print("Enter side 2: ");
        double b = sc.nextDouble();
        System.out.print("Enter side 3: ");
        double c = sc.nextDouble();

        System.out.println("Rounds required: " + calculateRounds(a, b, c));
    }
}
