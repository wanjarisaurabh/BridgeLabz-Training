
import java.util.Scanner;

/*
 * Program Name : ResultGenerator
 * Description  : Calculates average and grade
 */
public class ResultGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;

        // Input marks
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter marks of subject " + i + ": ");
            total += sc.nextInt();
        }

        double average = total / 5.0;

        // Grade using switch
        char grade;
        switch ((int) average / 10) {
            case 9:
            case 8:
                grade = 'A';
                break;
            case 7:
                grade = 'B';
                break;
            case 6:
                grade = 'C';
                break;
            case 5:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }

        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
    }
}
