import java.util.Scanner;

public class BMICalculation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // a. Take input for number of persons
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        // b. Create arrays
        double[] height = new double[n];   // in meters
        double[] weight = new double[n];   // in kg
        double[] bmi = new double[n];
        String[] status = new String[n];

        // c. Take input for height and weight
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            System.out.print("Enter height (in meters): ");
            height[i] = sc.nextDouble();

            System.out.print("Enter weight (in kg): ");
            weight[i] = sc.nextDouble();
        }

        // d. Calculate BMI and determine status
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            // f. Determine weight status using BMI table
            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // e. Display height, weight, BMI and status
        System.out.println("\n----- BMI REPORT -----");
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Height : " + height[i] + " m");
            System.out.println("Weight : " + weight[i] + " kg");
            System.out.println("BMI    : " + String.format("%.2f", bmi[i]));
            System.out.println("Status : " + status[i]);
            System.out.println("----------------------");
        }

        sc.close();
    }
}
