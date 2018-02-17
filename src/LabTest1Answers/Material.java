/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabTest1Answers;
import java.time.*;         // 1 mark
/**
 *
 * @author ngsm
 */
public class Material extends Contribution{     // 2marks
    
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
    { // header 2 marks - date, + others
        super(date);    // 2 marks
        this.category = category;   //  1 mark
        if (!description.isEmpty()) // 2 marks
            this.description = description;
        else
            this.description = "unknown";
        if (valuePerUnit > 0)  // 2marks
            this.valuePerUnit = valuePerUnit;
        else
            this.valuePerUnit = 0;
        if (numUnitsContributed > 0)  // 2marks
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
