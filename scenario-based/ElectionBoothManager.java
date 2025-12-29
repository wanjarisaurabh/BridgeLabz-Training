
import java.util.Scanner;

/*
 * Program Name : ElectionBoothManager
 * Description  : Checks voter eligibility and records votes
 */
public class ElectionBoothManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vote1 = 0, vote2 = 0, vote3 = 0;

        while (true) {
            System.out.print("Enter age (or -1 to stop): ");
            int age = sc.nextInt();

            // Exit condition
            if (age == -1) {
                break;
            }

            // Check eligibility
            if (age >= 18) {
                System.out.print("Vote for candidate (1/2/3): ");
                int vote = sc.nextInt();

                if (vote == 1) {
                    vote1++; 
                }else if (vote == 2) {
                    vote2++; 
                }else if (vote == 3) {
                    vote3++; 
                }else {
                    System.out.println("Invalid vote!");
                }
            } else {
                System.out.println("Not eligible to vote.");
            }
        }

        // Display results
        System.out.println("\nVoting Result:");
        System.out.println("Candidate 1: " + vote1);
        System.out.println("Candidate 2: " + vote2);
        System.out.println("Candidate 3: " + vote3);
    }
}
