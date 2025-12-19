// Program to calculate percentage and grade using 2D array
import java.util.Scanner;

public class MarksGrade_2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double[][] marks = new double[n][3];
        double[] percent = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            marks[i][0] = sc.nextDouble();
            marks[i][1] = sc.nextDouble();
            marks[i][2] = sc.nextDouble();
        }

        // Calculating percentage and grade
        for (int i = 0; i < n; i++) {
            percent[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3;

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
