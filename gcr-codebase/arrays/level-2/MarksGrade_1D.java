// Program to calculate percentage and grade using 1D arrays
import java.util.Scanner;

public class MarksGrade_1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double[] percent = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            double p = sc.nextDouble();
            double c = sc.nextDouble();
            double m = sc.nextDouble();

            percent[i] = (p + c + m) / 3;

            grade[i] = (percent[i] >= 90) ? "A" :
                       (percent[i] >= 75) ? "B" :
                       (percent[i] >= 60) ? "C" : "D";
        }

        // Displaying percentage and grade
        for (int i = 0; i < n; i++)
            System.out.println(percent[i] + " " + grade[i]);

        sc.close();
    }
}
