
import java.util.Scanner;

/*
 * Program Name : BusAttendanceSystem
 * Description  : Tracks student attendance
 */
public class BusAttendanceSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] students = {
            "Aman", "Ravi", "Neha", "Pooja", "Rohit",
            "Ankit", "Kiran", "Meena", "Sahil", "Riya"
        };

        int present = 0, absent = 0;

        for (String name : students) {
            System.out.print("Is " + name + " present? (P/A): ");
            char status = sc.next().charAt(0);

            if (status == 'P' || status == 'p') {
                present++; 
            }else {
                absent++;
            }
        }

        System.out.println("Present: " + present);
        System.out.println("Absent: " + absent);
    }
}
