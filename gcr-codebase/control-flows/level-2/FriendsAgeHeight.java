import java.util.Scanner;
public class FriendsAgeHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aAge = sc.nextInt(), aH = sc.nextInt();
        int bAge = sc.nextInt(), bH = sc.nextInt();
        int cAge = sc.nextInt(), cH = sc.nextInt();
        System.out.println(Math.min(aAge, Math.min(bAge, cAge)));
        System.out.println(Math.max(aH, Math.max(bH, cH)));
    }
}
