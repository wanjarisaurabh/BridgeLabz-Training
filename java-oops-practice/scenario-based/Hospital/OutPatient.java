
package Hospital;

public class OutPatient extends Patient {

    public OutPatient(String name, int id) {
        super(name, id);
    }

    @Override
    public String getPatientType() {
        return "Out-Patient";
    }
}
