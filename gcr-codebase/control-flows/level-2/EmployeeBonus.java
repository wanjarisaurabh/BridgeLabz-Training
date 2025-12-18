import java.util.Scanner;
public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        int years = sc.nextInt();
        if (years > 5)
            System.out.println(salary * 0.05);
        else
            System.out.println("No bonus");
    }
}
