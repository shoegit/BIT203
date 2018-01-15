/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A class to represent worker objects.
 * Workers have a name, hourlyRate and hoursWorked
 *
 * @author ngsm
 */
public class Worker {

    private String name;
    private double hourlyRate;
    private int hoursWorked;
    public static final double OVERTIMERATE = 1.5;
    public static final int OVERTIMERANGE = 40;

    /**
     * default constructor
     */
    public Worker() {
        name = "unknown";
        hourlyRate = 0.0;
        hoursWorked = 0;
    }

    /**
     * a method to set the name
     * @param inName 
     */
    public void setName(String inName) {
        name = inName;
    }

    /**
     * a method to set the hourly rate
     * @param inHourlyRate 
     */
    public void setHourlyRate(double inHourlyRate) {
        if (inHourlyRate > 0) {
            hourlyRate = inHourlyRate;
        }
    }
    
    /**
     * A method to set the hours worked
     * @param inHoursWorked the number of hours worked in a week
     */
    public void setHoursWorked(int inHoursWorked)
    {
        if (inHoursWorked > 0)
            hoursWorked = inHoursWorked;
    }

    /**
     * A method to get the name
     * @return name of the worker
     */
    public String getName()
    {
        return name; 
    }
    
    /**
     * a method to get the hourlyRate
     * @return the hourly rate for the worker
     */
    public double getHourlyRate()
    {
        return hourlyRate;
    }
    
    /**
     * A method to return the number of hours worked
     * @return the number of hours worked
     */
    public int getHoursWorked()
    {
        return hoursWorked;
    }
       
    /**
     * 
     * @return information about the worker 
     */
    public String toString()
    {
        return "Worker " + name + " at hourly rate of RM" + hourlyRate + " worked " + hoursWorked + " hours this week";
    }
}
