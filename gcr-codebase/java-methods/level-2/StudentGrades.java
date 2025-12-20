import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // Arrays to store marks, percentages, and grades
        int[] physicsMarks = new int[n];
        int[] chemistryMarks = new int[n];
        int[] mathsMarks = new int[n];
        double[] percentages = new double[n];
        char[] grades = new char[n];

        // Input marks for each student
        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");

            // Physics marks
            do {
                System.out.print("Physics: ");
                physicsMarks[i] = sc.nextInt();
                if (physicsMarks[i] < 0) {
                    System.out.println("Marks cannot be negative. Enter again.");
                }
            } while (physicsMarks[i] < 0);

            // Chemistry marks
            do {
                System.out.print("Chemistry: ");
                chemistryMarks[i] = sc.nextInt();
                if (chemistryMarks[i] < 0) {
                    System.out.println("Marks cannot be negative. Enter again.");
                }
            } while (chemistryMarks[i] < 0);

            // Maths marks
            do {
                System.out.print("Maths: ");
                mathsMarks[i] = sc.nextInt();
                if (mathsMarks[i] < 0) {
                    System.out.println("Marks cannot be negative. Enter again.");
                }
            } while (mathsMarks[i] < 0);

            // Calculate percentage
            percentages[i] = (physicsMarks[i] + chemistryMarks[i] + mathsMarks[i]) / 3.0;

            // Assign grade based on percentage
            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        // Display results
        System.out.println("\nStudent Results:");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.2f\t\t%c\n", i + 1, physicsMarks[i], chemistryMarks[i], mathsMarks[i], percentages[i], grades[i]);
        }

        sc.close();
    }
}
