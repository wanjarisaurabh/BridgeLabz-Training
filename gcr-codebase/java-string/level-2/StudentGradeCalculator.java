import java.util.Scanner;

public class StudentGradeCalculator {

    // a) Generate random 2-digit PCM scores for all students
    public static int[][] generatePCMScores(int students) {
        int[][] pcm = new int[students][3]; // Physics, Chemistry, Maths

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                pcm[i][j] = (int) (Math.random() * 90) + 10; // 10–99
            }
        }
        return pcm;
    }

    // b) Calculate total, average, percentage (rounded to 2 digits)
    public static double[][] calculateResults(int[][] pcm) {
        int students = pcm.length;
        double[][] result = new double[students][3]; // total, average, percentage

        for (int i = 0; i < students; i++) {
            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    // c) Calculate grade based on percentage
    public static String[] calculateGrades(double[][] result) {
        String[] grades = new String[result.length];

        for (int i = 0; i < result.length; i++) {
            double percentage = result[i][2];

            if (percentage >= 80)
                grades[i] = "A";
            else if (percentage >= 70)
                grades[i] = "B";
            else if (percentage >= 60)
                grades[i] = "C";
            else if (percentage >= 50)
                grades[i] = "D";
            else if (percentage >= 40)
                grades[i] = "E";
            else
                grades[i] = "R";
        }
        return grades;
    }

    // d) Display scorecard in tabular format
    public static void displayScoreCard(int[][] pcm, double[][] result, String[] grades) {

        System.out.println("\nScorecard");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAverage\t\tPercentage\tGrade");
        System.out.println("--------------------------------------------------------------------------------");

        for (int i = 0; i < pcm.length; i++) {
            System.out.println(
                (i + 1) + "\t" +
                pcm[i][0] + "\t" +
                pcm[i][1] + "\t" +
                pcm[i][2] + "\t" +
                (int) result[i][0] + "\t" +
                result[i][1] + "\t\t" +
                result[i][2] + "%\t\t" +
                grades[i]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        // Step a
        int[][] pcmScores = generatePCMScores(students);

        // Step b
        double[][] results = calculateResults(pcmScores);

        // Step c
        String[] grades = calculateGrades(results);

        // Step d
        displayScoreCard(pcmScores, results, grades);

        sc.close();
    }
}
