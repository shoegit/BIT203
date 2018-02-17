package LabTest1Answers;

import java.time.LocalDate;

/**
 * REPLACE WITH YOUR STUDENTID
 * @author ngsm
 */
public class TestAnswers {
    
    public static void main(String[] args)
    {
        // Initializing test values for the instance variables
        LocalDate testDate = LocalDate.now();
        MaterialType testMaterial = MaterialType.CLOTHING;
        String description = "T-shirts";
        double valuePerUnit = 3.50;
        int numUnits = 5;
        double donationAmount = 20;
        
        // 1. Which of the two lines to declare a Contribution
        // is correct? Why? 
        // Comment out the wrong line and explain your answer in the comment.
       // Contribution cont = new Contribution(testDate) ;     abstract class - 2 marks
        Contribution cont = null;  
        
        // 2. create a Material object 
        // using the correct test values from lines 19 - 24 above
        Material mat = new Material(testDate, testMaterial, description, valuePerUnit, numUnits);      // fill in the rest
        
        // 3. create a Monetary  object 
        // using the correct test values from lines 19 - 24 above
        Monetary mon =  new Monetary(testDate, donationAmount);         // fill in the rest
        
        // For each of the following lines 45 - 49, state whether it will have:
        // a) a compile error
        // b) a possible runtime error
        // c) no error?
        // explain why, in your comments.
        // then comment out the errors
     //   mat = mon;        // compile error, mat is for Material and mon is not
   //     mat = cont;   // compile error, subclass type cannot refer to superclass
        cont = mon;        // no error, superclass type refer to Monetary object 
        mon = (Monetary) cont;    // no error, 
   //     mat = (Material) cont;    // possible runtime error, cont is now Monetary object
        
        // Which method is invoked in each of the following:
        // a) the one in Contribution
        // b) the one in Material
        // c) the one in Monetary
        // give your answer and explain why in the comments
        System.out.println(cont.toString());  // (c) because cont is referring to a Monetary object
        System.out.println(mat.toString());  // (b) material object calling 
        System.out.println(cont.getValue()); // (c) cont is a monetary object
        System.out.println(mon.getValue()); // (c) mon is a monetary object
        
    }
}
