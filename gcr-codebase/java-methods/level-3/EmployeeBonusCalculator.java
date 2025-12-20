
public class EmployeeBonusCalculator {

    // Method to generate salary and years of service using Math.random()
    public static double[][] generateEmployeeData() {

        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            // 5-digit salary (10000 – 99999)
            data[i][0] = (int) (Math.random() * 90000) + 10000;

            // Years of service (1 – 10)
            data[i][1] = (int) (Math.random() * 10) + 1;
        }
        return data;
    }

    // Method to calculate new salary and bonus
    public static double[][] calculateBonus(double[][] data) {

        double[][] result = new double[10][4];

        for (int i = 0; i < 10; i++) {

            double salary = data[i][0];
            double years = data[i][1];
            double bonusRate;

            if (years > 5) {
                bonusRate = 0.05; 
            }else {
                bonusRate = 0.02;
            }

            double bonus = salary * bonusRate;
            double newSalary = salary + bonus;

            result[i][0] = salary;
            result[i][1] = years;
            result[i][2] = bonus;
            result[i][3] = newSalary;
        }
        return result;
    }

    // Method to calculate totals and display table
    public static void displayResult(double[][] result) {

        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;

        System.out.println("Emp\tOldSalary\tYears\tBonus\t\tNewSalary");

        for (int i = 0; i < 10; i++) {

            totalOldSalary += result[i][0];
            totalBonus += result[i][2];
            totalNewSalary += result[i][3];

            System.out.printf("%d\t%.0f\t\t%.0f\t%.2f\t\t%.2f\n",
                    (i + 1),
                    result[i][0],
                    result[i][1],
                    result[i][2],
                    result[i][3]);
        }

        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Amount: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
    }

    public static void main(String[] args) {

        double[][] employeeData = generateEmployeeData();
        double[][] result = calculateBonus(employeeData);
        displayResult(result);
    }
}
