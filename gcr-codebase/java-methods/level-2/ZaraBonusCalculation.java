import java.util.Scanner;

public class ZaraBonusCalculation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalEmployees = 10;

        // Arrays to store data
        double[] salary = new double[totalEmployees];
        double[] yearsOfService = new double[totalEmployees];
        double[] bonus = new double[totalEmployees];
        double[] newSalary = new double[totalEmployees];

        // Variables for totals
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Input loop
        for (int i = 0; i < totalEmployees; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Enter Salary: ");
            salary[i] = sc.nextDouble();

            System.out.print("Enter Years of Service: ");
            yearsOfService[i] = sc.nextDouble();

            // Validation check
            if (salary[i] <= 0 || yearsOfService[i] < 0) {
                System.out.println("Invalid input! Please enter valid values.");
                i--; // decrement index to re-enter data
                continue;
            }
        }

        // Bonus calculation loop
        for (int i = 0; i < totalEmployees; i++) {

            // Bonus based on years of service
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }

            // New salary
            newSalary[i] = salary[i] + bonus[i];

            // Totals
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Display results
        System.out.println("\n----- Zara Bonus Summary -----");
        System.out.println("Total Old Salary  : " + totalOldSalary);
        System.out.println("Total Bonus Paid  : " + totalBonus);
        System.out.println("Total New Salary  : " + totalNewSalary);

        sc.close();
    }
}
