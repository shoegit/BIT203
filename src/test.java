/**
 * A program to find and display the weekly wage of a worker,
 * the data is to be entered interactively by an administrative clerk – use the Scanner class.
 * @author ngsm
 */
import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final double HOURLYRATE = 12.50;
        final double OVERTIMERATE = 1.5;
        final int OVERTIMERANGE = 40;
        
        // prompt user for hours worked
        System.out.print("Enter the hours worked :");
        int hoursWorked = sc.nextInt();
        double weeklyWage;
        
        if (hoursWorked > OVERTIMERANGE)
        {
            int extraHours = hoursWorked - OVERTIMERANGE;
            double extraPay = extraHours * HOURLYRATE * OVERTIMERATE;
            weeklyWage = HOURLYRATE * OVERTIMERANGE + extraPay;
        }
        else
            weeklyWage = HOURLYRATE * hoursWorked;
        System.out.printf("The weekly wage is RM%5.2f%n",  weeklyWage);

    }
}
