/**
 * A program to find and display the weekly wage of a worker,
 * the data is to be entered interactively by an administrative clerk – use the Scanner class.
 * @author ngsm
 */
import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double hourlyRate = 12.50;
        
        // prompt user for hours worked
        System.out.print("Enter the hours worked :");
        int hoursWorked = sc.nextInt();
        
        // display the weekly wage
        double weeklyWage = hourlyRate * hoursWorked;
        System.out.printf("The weekly wage is RM%5.2f%n",  weeklyWage);

    }
}
