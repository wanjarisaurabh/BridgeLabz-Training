
import java.util.Scanner;

public class FactorialOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        
	
	int i = 1;
        int factorial = 1;
        while ( i <= number) {
  	factorial *= i;
	i++;         

	}
	
	System.out.println("Factorial of number :" + factorial);	

        
    }
}
