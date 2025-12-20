import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Names of friends
        String[] names = {"Amar", "Akbar", "Anthony"};

        // Arrays to store age and height
        int[] age = new int[3];
        double[] height = new double[3];

        // Take user input
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for " + names[i]);

            System.out.print("Age: ");
            age[i] = sc.nextInt();

            System.out.print("Height: ");
            height[i] = sc.nextDouble();
        }

        // Assume first friend is youngest and tallest initially
        int youngestIndex = 0;
        int tallestIndex = 0;

        // Loop to find youngest and tallest
        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngestIndex]) {
                youngestIndex = i;
            }

            if (height[i] > height[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display results
        System.out.println("\nYoungest Friend : " + names[youngestIndex]);
        System.out.println("Tallest Friend  : " + names[tallestIndex]);

        sc.close();
    }
}
