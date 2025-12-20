import java.util.Scanner;

public class WindChill {

    // Method to calculate wind chill
    public static double calculateWindChill(double temp, double speed) {
        return 35.74 + 0.6215 * temp +
               (0.4275 * temp - 35.75) * Math.pow(speed, 0.16);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double temp = sc.nextDouble();
        double speed = sc.nextDouble();

        System.out.println("Wind Chill: " + calculateWindChill(temp, speed));
    }
}
