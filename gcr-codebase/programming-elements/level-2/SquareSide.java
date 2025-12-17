
import java.util.Scanner;

class SquareSide {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input
        System.out.print("Enter perimeter of square: ");
        double perimeter = sc.nextDouble();

        //logic code
        double side = perimeter / 4;

        //output
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
    }
}
