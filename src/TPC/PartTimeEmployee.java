/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPC;

/**
 *
 * @author ngsm
 */
public class PartTimeEmployee extends Employee{
    
    private double hourlyRate;
    
    public PartTimeEmployee()
    {
        this("Unknown", 0.0);
    }
    
    public PartTimeEmployee(String name, double hourlyRate)
    {
        super(name);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
   @Override
    public String toString()
    {
        return getName() + " with employee number " + getEmpNum() + " and hourly rate " + hourlyRate;
    }
}
    

