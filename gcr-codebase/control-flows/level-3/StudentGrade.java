
import java.util.Scanner;
public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();
        double avg = (p + c + m) / 3.0;
        System.out.println("Average Marks: " + avg);
        if (avg >= 75) System.out.println("Grade A");
        else if (avg >= 60) System.out.println("Grade B");
        else if (avg >= 50) System.out.println("Grade C");
        else System.out.println("Fail");
    }
}
