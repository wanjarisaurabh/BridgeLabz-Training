
package University;

public abstract class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getTranscript() {
        return "Student Name: " + name;
    }
}
