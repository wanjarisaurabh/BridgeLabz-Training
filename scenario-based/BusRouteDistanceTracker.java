
import java.util.Scanner;

/*
 * Program: BusRouteDistanceTracker
 * Description:
 * Tracks distance added at each stop.
 * Uses while-loop and user confirmation to exit.
 */
public class BusRouteDistanceTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int totalDistance = 0;
        char stopChoice = 'n';

        while (stopChoice != 'y') {

            System.out.print("Enter distance for next stop (km): ");
            int distance = sc.nextInt();
            totalDistance += distance;

            System.out.println("Total Distance Covered: " + totalDistance + " km");

            System.out.print("Do you want to get off? (y/n): ");
            stopChoice = sc.next().toLowerCase().charAt(0);
        }

        System.out.println("Journey Ended. Total Distance: " + totalDistance + " km");
    }
}
