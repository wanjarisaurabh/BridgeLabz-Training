// Program to calculate BMI using 1D arrays
import java.util.Scanner;

public class BMI_1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double[] height = new double[n];
        double[] weight = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextDouble();
            weight[i] = sc.nextDouble();
        }

        // Calculating BMI and status
        for (int i = 0; i < n; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);
            status[i] = (bmi[i] < 18.5) ? "Underweight" :
                        (bmi[i] < 25) ? "Normal" :
                        (bmi[i] < 30) ? "Overweight" : "Obese";
        }

        // Displaying BMI details
        for (int i = 0; i < n; i++)
            System.out.println(bmi[i] + " " + status[i]);

        sc.close();
    }
}
