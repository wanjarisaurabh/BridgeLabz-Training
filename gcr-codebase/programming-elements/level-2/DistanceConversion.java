
import java.util.Scanner;

class DistanceConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = sc.nextDouble();

        //logic code
        double yards = distanceInFeet / 3;
        double miles = yards / 1760;

        //output
        System.out.println("The distance in yards is " + yards + " while the distance in miles is " + miles);
    }
}
