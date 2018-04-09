
package Lecture13;

/**
 * A class to demonstrate threads by implementing Runnable
 * A thread that printa s given character 100 times.
 * @author ngsm
 */
public class AlphaThread2 implements Runnable {

    private char letter;

    public AlphaThread2(char letter) {
        this.letter = letter;
    }
    
    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.print(letter);
        } 
    }
            
}
