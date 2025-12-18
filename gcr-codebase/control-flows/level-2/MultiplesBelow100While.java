import java.util.Scanner;
public class MultiplesBelow100While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int i = 100;
        while (i >= 1) {
            if (i % number == 0)
                System.out.println(i);
            i--;
        }
    }
}
