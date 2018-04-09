package Lecture13;

/**
 * A class to demonstrate threads
 * A thread that printa s given character 100 times.
 * @author ngsm
 */
public class AlphaThread extends Thread {

    private char letter;

    public AlphaThread(char letter) {
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
