package LabTest1Answers;
// import package - 2 marks
import java.time.*;
/**
 * If you are using this class in your assignment 
 * please indicate that you are modifying from this version.
 * @author ngsm
 */
public abstract class Contribution {    // header - 3 marks
    
    private static int nextNo = 1000;   // nextNo -  3 marks
    private int contributionNo;         // 2 marks
    private LocalDate date;             // 2 marks
    
    /**
     * 3 marks
     * A private method setContributionNo() that will generate a unique contributionNo 
     * for a Contribution object using the nextNo static variable.
     */
    private void setContributionNo()
    {
        contributionNo = nextNo++;
    }
    
    /**
     * 6 marks
     * parameter - 2 marks
     * setContribution - 2 marks
     * set Date - 2 marks
     * @param date 
     */
    public Contribution(LocalDate date)
    {
        setContributionNo();
        if (!date.isAfter(LocalDate.now()))
            this.date = date;
    }
    
    /**
     * 3 marks, abstract and return type
     * @return 
     */
    public abstract double getValue();
    
    /**
     * 4 marks
     * @return 
     */
    public String toString()
    {
        return "Contribution " + contributionNo + " made on " + date;
    }
}
