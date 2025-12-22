
import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    // Generates ArrayIndexOutOfBoundsException
    static void createException(String[] arr) {
        System.out.println(arr[arr.length]);
    }

    // Handles the exception
    static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = sc.nextInt();
        String[] arr = new String[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.next();
        }
        try {
            createException(arr);
        } catch (Exception e) {
            handleException(arr);
        }
    }
}
