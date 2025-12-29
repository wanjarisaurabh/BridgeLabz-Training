
import java.util.Scanner;

/*
 * Program Name : ParkingLotSystem
 * Description  : Manages parking operations
 */
public class ParkingLotSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = 5;
        int parked = 0;

        while (true) {
            System.out.println("\n1. Park\n2. Exit\n3. Show Occupancy\n4. Quit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (parked < capacity) {
                        parked++;
                        System.out.println("Vehicle parked.");
                    } else {
                        System.out.println("Parking Full!");
                    }
                    break;

                case 2:
                    if (parked > 0) {
                        parked--;
                        System.out.println("Vehicle exited.");
                    } else {
                        System.out.println("Parking empty!");
                    }
                    break;

                case 3:
                    System.out.println("Occupied: " + parked + "/" + capacity);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
