
/**
 * A program to find and display the weekly wage of a worker,
 * the data is to be entered interactively by an administrative clerk – use the Scanner class.
 *
 * @author ngsm
 */
import java.util.Scanner;

public class test {

    final static double HOURLYRATE = 12.50;
    static final double OVERTIMERATE = 1.5;
    static final int OVERTIMERANGE = 40;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter number of workers  :");
        int numWorkers = sc.nextInt();
        double total = 0.0;
        for (int i = 1; i <= numWorkers; i++) { 
            
            total += getWorkerWage(i);
            
        }

        System.out.printf("The total wages paid is RM%5.2f%n", total);

    }

    /**
     * A method to get info about one worker
     *
     */
    public static double getWorkerWage(int workerNum) {
        // prompt user for hours worked
        System.out.print("Enter the hours worked for worker " + workerNum + ": ");
        int hoursWorked = sc.nextInt();
        double weeklyWage = calculateWage(hoursWorked);

        System.out.printf("The weekly wage for worker %d is RM%5.2f%n", workerNum, weeklyWage);
        return weeklyWage;
    }

    /**
     * A method to calculate the weekly wage given the hours worked
     *
     * @param hours
     * @return the weekly wage for a worker
     */
    public static double calculateWage(int hours) {
        double weeklyWage;
        if (hours > OVERTIMERANGE) {
            int extraHours = hours - OVERTIMERANGE;
            double extraPay = extraHours * HOURLYRATE * OVERTIMERATE;
            weeklyWage = HOURLYRATE * OVERTIMERANGE + extraPay;
        } else {
            weeklyWage = HOURLYRATE * hours;
        }
        return weeklyWage;
    }
}
