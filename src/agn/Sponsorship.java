package agn;
import java.time.*;
/**
 *
 * @author ngsm
 */
public class Sponsorship extends Contribution {
    
    // Instance variables
    private int percentage;
    private static double maxSponsorshipValue = 150;
    private Child theChild; // Store the child info who belong to the sponsorship
    
    /**
     * Constructor
     * @param date
     * @param percentage 
     */
    public Sponsorship (LocalDate date, int percentage) {
        super(date);
        if (percentage > 0)
            this.percentage = percentage;
        else
            this.percentage = 0;
        this.theChild = null;
    }
    
    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        if (percentage > 0)
            this.percentage = percentage;
        else
            this.percentage = 0;
    }
    
    /**
     * A method to get the Child belong to this sponsorship
     * @return the child who belong to this sponsorship
     */
    public Child getTheChild() {
        return theChild;
    }
    
    /**
     * A method to set the Child belong to this sponsorship
     */
    public void setTheChild(Child theChild) {
        this.theChild = theChild;
    }
    
    /**
     * A method to calculate the value of a sponsorship
     * @return the value
     */
    @Override
    public double getValue() {
        return (getPercentage() / 100.00 ) * maxSponsorshipValue;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nPercentage of sponsorship : " + getPercentage(); 
    }
    
}
