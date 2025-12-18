
import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double w = sc.nextDouble();
        double h = sc.nextDouble() / 100;
        double bmi = w / (h * h);
        System.out.println("BMI: " + bmi);
    }
}
