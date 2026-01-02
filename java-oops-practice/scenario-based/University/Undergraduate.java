
package University;

public class Undergraduate extends Student implements Graded {

    public Undergraduate(String name) {
        super(name);
    }

    @Override
    public void assignGrade(int marks) {
        System.out.println(marks >= 40 ? "Pass" : "Fail");
    }
}
