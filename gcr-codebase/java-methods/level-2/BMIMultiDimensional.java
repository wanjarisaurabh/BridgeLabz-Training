import java.util.Scanner;

public class BMIMultiDimensional {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input for number of persons
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        // Create 2D array: [person][height, weight, BMI]
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Take input for height and weight with validation
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            // Height input
            while (true) {
                System.out.print("Enter height (in meters): ");
                double height = sc.nextDouble();
                if (height > 0) {
                    personData[i][0] = height;
                    break;
                } else {
                    System.out.println("Height must be positive. Please enter again.");
                }
            }

            // Weight input
            while (true) {
                System.out.print("Enter weight (in kg): ");
                double weight = sc.nextDouble();
                if (weight > 0) {
                    personData[i][1] = weight;
                    break;
                } else {
                    System.out.println("Weight must be positive. Please enter again.");
                }
            }
        }

        // Calculate BMI and weight status
        for (int i = 0; i < number; i++) {

            double height = personData[i][0];
            double weight = personData[i][1];

            // BMI calculation
            personData[i][2] = weight / (height * height);

            // Determine weight status
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display result
        System.out.println("\n----- BMI REPORT -----");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            System.out.println("Height : " + personData[i][0] + " m");
            System.out.println("Weight : " + personData[i][1] + " kg");
            System.out.println("BMI    : " + String.format("%.2f", personData[i][2]));
            System.out.println("Status : " + weightStatus[i]);
            System.out.println("----------------------");
        }

        sc.close();
    }
}
