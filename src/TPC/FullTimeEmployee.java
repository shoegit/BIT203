package TPC;


/* A class to represent <code>FullTimeEmployee</code> objects. 
 * extends the Employee class
 * @author ngsm
 */

public class FullTimeEmployee extends Employee{
    private double monthlySalary;
    
    /** Constructor without arguments
     * 
     */
    public FullTimeEmployee()
    {
        this("unknown", 0.0);
    }
    
    public FullTimeEmployee(String name, double monthlySalary)
    {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
    
    @Override
    public String toString()
    {
        return getName() + " with employee number " + getEmpNum() + " and monthly salary " + monthlySalary;
    }

    @Override
    public double calculatePay() {
        return monthlySalary;
    }
}
