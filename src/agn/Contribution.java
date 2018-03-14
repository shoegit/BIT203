/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agn;
// import package - 2 marks
import java.time.*;
/**
 * Contribution is something that is given to AGN
 * @author ngsm
 */
public abstract class Contribution implements Comparable<Contribution> {    
    
    private static int nextNo = 1000;   
    private int contributionNo;        
    private LocalDate date; 
    private Donor theDonor;     // the person who made the contribution

    public Donor getTheDonor() {
        return theDonor;
    }

    public void setTheDonor(Donor theDonor) {
        this.theDonor = theDonor;
    }
    
    /**
     * 
     * A private method setContributionNo() that will generate a unique contributionNo 
     * for a Contribution object using the nextNo static variable.
     */
    private void setContributionNo()
    {
        contributionNo = nextNo++;
    }
    
    /**
     * 
     * 
     * @param date 
     */
    public Contribution(LocalDate date)
    {
        setContributionNo();
        if (!date.isAfter(LocalDate.now()))
            this.date = date;
    }

    public static int getNextNo() {
        return nextNo;
    }

    public static void setNextNo(int nextNo) {
        Contribution.nextNo = nextNo;
    }

    public int getContributionNo() {
        return contributionNo;
    }

    

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    /**
     * A method to get the value of the contribution
     * @return double value representing value of the contribution
     */
    public abstract double getValue();
    
    
    public int compareTo(Contribution c)
    {
        // compare contributions by date
        if (this.getDate().isBefore(c.getDate()))
            return -1;
        else if (this.getDate().isAfter(c.getDate()))
            return 1;
        else return 0;
    }
    /**
     * Info about contribution
     * @return toString
     */
    public String toString()
    {
        return "Contribution " + contributionNo + " made on " + date;
    }
}
