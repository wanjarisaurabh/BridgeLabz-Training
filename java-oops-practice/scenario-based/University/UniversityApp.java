
package University;

public class UniversityApp {
    public static void main(String[] args) {

        Student student = new Undergraduate("Ankit");

        System.out.print("Grade Result: ");
        ((Graded) student).assignGrade(78);
    }
}
