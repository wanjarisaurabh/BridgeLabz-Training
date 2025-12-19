// Program to find youngest and tallest friend
import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {
            age[i] = sc.nextInt();
            height[i] = sc.nextDouble();
        }

        int youngest = age[0];
        double tallest = height[0];

        // Finding youngest age and tallest height
        for (int i = 1; i < 3; i++) {
            if (age[i] < youngest) youngest = age[i];
            if (height[i] > tallest) tallest = height[i];
        }

        System.out.println("Youngest Age = " + youngest);
        System.out.println("Tallest Height = " + tallest);

        sc.close();
    }
}
