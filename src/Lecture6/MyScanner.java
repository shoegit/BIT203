/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture6;

import java.io.*;

/**
 *
 * @author ngsm
 */
public class MyScanner {

    public static void main(String[] args) throws IOException{
        
        System.out.println("Enter a positive integer");
        try{
            int num = getInteger();
            if (num < 0)
                throw new NegativeNumException(num);
            if (num == 0)
                throw new NegativeNumException("0 is NOT positive");
            System.out.println("You entered " + num);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("You didn't enter an integer");
        }
        catch(NegativeNumException ne)
        {
            System.out.println(ne.getMessage());
        }
    }

    public static int getInteger() throws IOException{
        // declare a large byte array
        byte[] buffer = new byte[512];
        // characters entered stored in array 
        System.in.read(buffer);
        // make string from byte array
        String s = new String(buffer);
        // trim string
        s = s.trim();
        // converts string to an 'int'
        int num = Integer.parseInt(s);
        // send back integer value
        return num;

    }
}
