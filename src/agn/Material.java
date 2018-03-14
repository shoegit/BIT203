/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agn;
import java.time.*;         
/**
 *
 * @author ngsm
 */
public class Material extends Contribution{     
    
    // instance variables - 8 marks
    private MaterialType category;
    private String description;
    private double valuePerUnit;
    private int numUnitsContributed;
    
    /**
     * Constructor - 10 marks
     * @param date
     * @param category
     * @param description
     * @param valuePerUnit
     * @param numUnitsContributed 
     */
    public Material(LocalDate date, MaterialType category, String description, double valuePerUnit, int numUnitsContributed)
    { // 
        super(date);    
        this.category = category;   
        if (!description.isEmpty()) 
            this.description = description;
        else
            this.description = "unknown";
        if (valuePerUnit > 0)  
            this.valuePerUnit = valuePerUnit;
        else
            this.valuePerUnit = 0;
        if (numUnitsContributed > 0)  
            this.numUnitsContributed = numUnitsContributed;
        else
            this.numUnitsContributed = 0;
    }
    
    /**
     * 3 marks
     * @return 
     */
    public double getValue()
    {
        return numUnitsContributed * valuePerUnit;
    }
    /**
     * 5 marks
     * @return 
     */
    public String toString()
    {
        String full = super.toString() + "\n";
        full += "category :" + category + "\n";
        full += "description :" + description + "\n";
        full += "value : " + getValue();
        return full;
    }

    
}
