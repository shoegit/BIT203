package LabTest1Answers;
import java.time.*;
/**
 * If you are using this class in your assignment 
 * please indicate that you are modifying from this version.
 * @author ngsm
 */
public class Monetary extends Contribution{

    private double donationAmount;
    
    public Monetary(LocalDate date, double donationAmount)
    {
        super(date);
        if (donationAmount > 0)
        this.donationAmount = donationAmount;
        else
            this.donationAmount = 0;
    }
    @Override
    public double getValue() {
        return donationAmount;
    }
    
    public String toString()
    {
        return super.toString() + "\nAmount Donated : " + donationAmount;
                
    }
    
}
