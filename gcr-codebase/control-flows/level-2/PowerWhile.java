import java.util.Scanner;
public class PowerWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();
        int result = 1;
        int i = 0;
        while (i < power) {
            result *= number;
            i++;
        }
        System.out.println(result);
    }
}
