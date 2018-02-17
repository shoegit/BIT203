/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabTest1Answers;
import java.time.*;
/**
 *
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
