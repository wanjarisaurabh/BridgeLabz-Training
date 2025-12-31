import java.util.Scanner;

/*
 * Program Name : TemperatureLogger
 * Description  : Records temperatures for 7 days,
 *                finds average and maximum temperature.
 */

public class TemperatureLogger {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double[] temperatures = new double[7];
        double totalTemperature = 0;
        double maxTemperature;

        // Input temperatures
        for (int day = 0; day < temperatures.length; day++) {
            System.out.print("Enter temperature for day " + (day + 1) + ": ");
            temperatures[day] = scanner.nextDouble();
        }

        // Initialize max with first day's temperature
        maxTemperature = temperatures[0];

        // Calculate total and max
        for (int day = 0; day < temperatures.length; day++) {
            totalTemperature += temperatures[day];

            if (temperatures[day] > maxTemperature) {
                maxTemperature = temperatures[day];
            }
        }

        double averageTemperature = totalTemperature / temperatures.length;

        // Display results
        System.out.println("\nAverage Temperature: " + averageTemperature);
        System.out.println("Maximum Temperature: " + maxTemperature);

        scanner.close();
    }
}
