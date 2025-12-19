// Program to calculate BMI using 2D array
import java.util.Scanner;

public class BMI_2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double[][] personData = new double[n][3];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            personData[i][0] = sc.nextDouble();
            personData[i][1] = sc.nextDouble();
        }

        // Calculating BMI and status
        for (int i = 0; i < n; i++) {
            personData[i][2] = personData[i][1] /
                               (personData[i][0] * personData[i][0]);
            status[i] = (personData[i][2] < 18.5) ? "Underweight" :
                        (personData[i][2] < 25) ? "Normal" :
                        (personData[i][2] < 30) ? "Overweight" : "Obese";
        }

        // Displaying BMI details
        for (int i = 0; i < n; i++)
            System.out.println(personData[i][2] + " " + status[i]);

        sc.close();
    }
}
