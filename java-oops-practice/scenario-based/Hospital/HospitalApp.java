
package Hospital;

public class HospitalApp {
    public static void main(String[] args) {

        Patient inPatient = new InPatient("Saurabh", 101, 4);
        Patient outPatient = new OutPatient("Rahul", 102);

        Bill bill = new Bill(15000);

        System.out.println(inPatient.getSummary());
        System.out.println("Patient Type: " + inPatient.getPatientType());

        System.out.println(outPatient.getSummary());
        System.out.println("Patient Type: " + outPatient.getPatientType());

        System.out.println("Final Bill Amount: " + bill.calculatePayment());
    }
}
