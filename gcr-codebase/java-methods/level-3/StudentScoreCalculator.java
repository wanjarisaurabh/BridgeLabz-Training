
public class StudentScoreCalculator {

    // Method to calculate total, average, and percentage
    // Returns 2D array: [total, average, percentage]
    public static double[][] calculateResult(int[][] pcmMarks) {

        int students = pcmMarks.length;
        double[][] result = new double[students][3];

        for (int i = 0; i < students; i++) {

            int total = pcmMarks[i][0] + pcmMarks[i][1] + pcmMarks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Rounding to 2 decimal places
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }

        return result;
    }

    // Method to display scorecard in tabular format
    public static void displayScoreCard(int[][] pcmMarks, double[][] result) {

        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\tPercent");

        for (int i = 0; i < pcmMarks.length; i++) {

            System.out.println(
                    (i + 1) + "\t"
                    + pcmMarks[i][0] + "\t"
                    + pcmMarks[i][1] + "\t"
                    + pcmMarks[i][2] + "\t"
                    + result[i][0] + "\t"
                    + result[i][1] + "\t"
                    + result[i][2]
            );
        }
    }
}
