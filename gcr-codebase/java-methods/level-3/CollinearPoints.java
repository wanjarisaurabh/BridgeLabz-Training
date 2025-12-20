
import java.util.Scanner;

public class CollinearPoints {

    // Method to check collinearity using slope formula
    public static boolean isCollinearBySlope(int x1, int y1,
            int x2, int y2,
            int x3, int y3) {

        // (y2 - y1)/(x2 - x1) == (y3 - y2)/(x3 - x2)
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }

    // Method to check collinearity using area of triangle
    public static boolean isCollinearByArea(int x1, int y1,
            int x2, int y2,
            int x3, int y3) {

        double area = 0.5 * (x1 * (y2 - y3)
                + x2 * (y3 - y1)
                + x3 * (y1 - y2));

        return area == 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1 y1: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        System.out.print("Enter x2 y2: ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        System.out.print("Enter x3 y3: ");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        System.out.println("\nUsing Slope Formula:");
        System.out.println("Collinear: "
                + isCollinearBySlope(x1, y1, x2, y2, x3, y3));

        System.out.println("\nUsing Area of Triangle Formula:");
        System.out.println("Collinear: "
                + isCollinearByArea(x1, y1, x2, y2, x3, y3));

        sc.close();
    }
}
