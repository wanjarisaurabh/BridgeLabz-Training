
import java.util.*;

public class SpringSeason {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int month = input.nextInt();
        int day = input.nextInt();

        if ((month == 3 && day >= 20 && day <= 31)
                || (month == 4 && day >= 1 && day <= 30)
                || (month == 5 && day >= 1 && day <= 31)
                || (month == 6 && day >= 1 && day <= 20)) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }

        input.close();
    }
}
