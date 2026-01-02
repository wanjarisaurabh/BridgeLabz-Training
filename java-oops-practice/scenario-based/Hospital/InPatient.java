
package Hospital;

public class InPatient extends Patient {
    private int daysAdmitted;

    public InPatient(String name, int id, int daysAdmitted) {
        super(name, id);
        this.daysAdmitted = daysAdmitted;
    }

    public int getDaysAdmitted() {
        return daysAdmitted;
    }

    @Override
    public String getPatientType() {
        return "In-Patient";
    }
}
