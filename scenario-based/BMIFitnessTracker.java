import java.util.Scanner;

/*
 * Program Name : BMIFitnessTracker
 * Description  : This program calculates BMI based on height and weight
 *                and displays the BMI category using if-else conditions.
 */
public class BMIFitnessTracker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter your weight in kilograms: ");
        double weightInKg = scanner.nextDouble();

        System.out.print("Enter your height in meters: ");
        double heightInMeters = scanner.nextDouble();

        // Calculate BMI
        double bmi = weightInKg / (heightInMeters * heightInMeters);

        System.out.println("Your BMI is: " + bmi);

        // Determine BMI category
        if (bmi < 18.5) {
            System.out.println("BMI Category: Underweight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("BMI Category: Normal");
        } else {
            System.out.println("BMI Category: Overweight");
        }

        scanner.close();
    }
}
