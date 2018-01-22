

/**
 *The program should allow the user to enter the five workers’ information 
 * and calculate their wages, then display the total wages paid for that week.
 * @author ngsm
 */
import java.util.*;

public class DigiCom {
    public static void main(String []args)
    {
        // Modify this program to answer Question 8 as homework
        
        // declare an array of 5 workers
        Worker[] workers = new Worker[5];
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        for (int i = 0; i < 5; i++)
        {
            workers[i] = new Worker();
            System.out.print("Enter name of worker "+ (i+1) + ":");
            String name = sc.nextLine();
            workers[i].setName(name);
            
            System.out.print("Enter hours worked for  "+ name + ":");
            int hours = sc.nextInt();
            workers[i].setHoursWorked(hours);
            
            System.out.print("Enter hourly pay for  "+ name + ":");
            double hourlyPay = sc.nextDouble();
            sc.nextLine();
            workers[i].setHourlyRate(hourlyPay);         
            
            double wages = workers[i].calculateWage();
            System.out.println("Total wages earned by " + name + " is " + wages);
            total += wages;
            
        }
        System.out.println("Total paid today is "  + total);
      
    }
}
