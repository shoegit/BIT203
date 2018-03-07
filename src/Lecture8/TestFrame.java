/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture8;
import javax.swing.JFrame;
/**
 *
 * @author ngsm
 */
public class TestFrame extends JFrame{
    
    public TestFrame()
    {
        super();
        setTitle("My Second JFrame");
        setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[]args)
    {
        TestFrame tf = new TestFrame();
        tf.setVisible(true);
    }
}
