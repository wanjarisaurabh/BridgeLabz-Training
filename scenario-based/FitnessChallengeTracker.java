import java.util.Scanner;

/*
 * Program Name : FitnessChallengeTracker
 * Description  : Tracks daily push-ups for a week,
 *                skips rest days and calculates total and average.
 */

public class FitnessChallengeTracker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] pushUps = new int[7];

        // Input push-ups count
        for (int day = 0; day < pushUps.length; day++) {
            System.out.print("Enter push-ups for day " + (day + 1) + ": ");
            pushUps[day] = scanner.nextInt();
        }

        int totalPushUps = 0;
        int activeDays = 0;

        // Calculate total and average using for-each
        for (int count : pushUps) {

            // Skip rest days
            if (count == 0) {
                continue;
            }

            totalPushUps += count;
            activeDays++;
        }

        double averagePushUps = (activeDays > 0)
                ? (double) totalPushUps / activeDays
                : 0;

        // Display results
        System.out.println("\nTotal Push-Ups: " + totalPushUps);
        System.out.println("Average Push-Ups per Active Day: " + averagePushUps);

        scanner.close();
    }
}
