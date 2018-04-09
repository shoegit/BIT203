/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture13;

/**
 *
 * @author ngsm
 */
public class TestThread2 {
    
    public static void main(String[] args)
    {
        AlphaThread2 at1 = new AlphaThread2('J');
        AlphaThread2 at2 = new AlphaThread2('A');
        AlphaThread2 at3 = new AlphaThread2('R');
        
        Thread th1 = new Thread(at1);
        th1.start();
        Thread th2 = new Thread(at2);
        th2.start();
        Thread th3 = new Thread(at3);
        th3.start();
        
        
    }
}
