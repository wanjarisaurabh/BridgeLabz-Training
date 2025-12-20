
import java.util.Random;

/*
 * Program Name : FootballTeamHeights
 * Description  : This program generates random heights for 11 football players
 *                and finds the shortest, tallest and mean height.
 */
public class FootballTeamHeights {

    // Method to calculate sum of heights
    public static int calculateSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum = sum + height;
        }
        return sum;
    }

    // Method to calculate mean height
    public static double calculateMean(int[] heights) {
        return (double) calculateSum(heights) / heights.length;
    }

    // Method to find shortest height
    public static int findShortest(int[] heights) {
        int min = Integer.MAX_VALUE;
        for (int height : heights) {
            if (height < min) {
                min = height;
            }
        }
        return min;
    }

    // Method to find tallest height
    public static int findTallest(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int height : heights) {
            if (height > max) {
                max = height;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        // Creating array to store heights of 11 players
        int[] heights = new int[11];

        // Random class is used to generate random values
        Random random = new Random();

        // Generating random heights between 150 and 250
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + random.nextInt(101);
        }

        // Displaying results
        System.out.println("Shortest Height : " + findShortest(heights));
        System.out.println("Tallest Height  : " + findTallest(heights));
        System.out.println("Mean Height     : " + calculateMean(heights));
    }
}
