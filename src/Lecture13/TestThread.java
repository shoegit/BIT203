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
public class TestThread {

    public static void main(String[] args) {
        AlphaThread at1 = new AlphaThread('l');
        AlphaThread at2 = new AlphaThread('o');
        AlphaThread at3 = new AlphaThread('v');
        AlphaThread at4 = new AlphaThread('e');

        // start the thread
        at1.start();
        at2.start();
        at3.start();
        at4.start();
    }
}
