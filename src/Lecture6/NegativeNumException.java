/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture6;

/**
 * An exception class to handle negative numbers
 * @author ngsm
 */
public class NegativeNumException extends Exception{
    public NegativeNumException()
    {
        super("I want a positive number");
    }
   
    public NegativeNumException(int badNum)
    {
        super(badNum + " is not a positive number");
    }
    
    public NegativeNumException(String message)
    {
        super(message);
    }
    
}
