
import java.util.Scanner;

/*
 * Program Name : BMICalculator
 * Description  : Calculates BMI of 10 persons and displays
 *                Height, Weight, BMI and Status in tabular form.
 */
public class BMICalculator {

    // Method to calculate BMI and Status
    public static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[10][4];
        for (int i = 0; i < 10; i++) {

            double weight = data[i][0];
            double heightCm = data[i][1];

            // Convert height from cm to meter
            double heightM = heightCm / 100;

            // BMI formula
            double bmi = weight / (heightM * heightM);

            String status;
            if (bmi <= 18.4) {
                status = "Underweight"; 
            }else if (bmi <= 24.9) {
                status = "Normal"; 
            }else if (bmi <= 39.9) {
                status = "Overweight"; 
            }else {
                status = "Obese";
            }

            result[i][0] = heightCm + "";
            result[i][1] = weight + "";
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = status;
        }
        return result;
    }

    // Method to display BMI details
    public static void displayResult(String[][] result) {
        System.out.println("\nHeight(cm)  Weight(kg)  BMI     Status");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "        "
                    + result[i][1] + "        "
                    + result[i][2] + "   "
                    + result[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];
        // Taking inpu
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));
            System.out.print("Enter weight (kg): ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm): ");
            data[i][1] = sc.nextDouble();
        }
        // Method calls
        String[][] result = calculateBMI(data);
        displayResult(result);

        sc.close();
    }
}
