
package Hospital;

public abstract class Patient {
    private String name;
    private int id;

    public Patient(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getSummary() {
        return "Patient Name: " + name + ", ID: " + id;
    }

    public abstract String getPatientType();
}
