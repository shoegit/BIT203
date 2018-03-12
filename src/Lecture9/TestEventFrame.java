/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture9;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author ngsm
 */
public class TestEventFrame extends JFrame implements ActionListener{

    private JButton btn;
    private JLabel lbl;
    private int numTimes = 0; // to count how many times the button has been clicked
 
    public TestEventFrame()
    {
           setTitle("Testing an Event");
           setSize(300,100);
           setLayout(new FlowLayout());
           
           // creating components
           lbl = new JLabel("Button clicked 0 times");
           btn = new JButton("OK");
           btn.addActionListener(this);
           
           add(lbl);
           add(btn);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       numTimes++;
       lbl.setText("Button clicked " + numTimes + " times");
    }
    
    public static void main(String[] args)
    {
        TestEventFrame tf = new TestEventFrame();
        tf.addWindowListener(new WindowCloser());
        tf.setVisible(true);
        
    }
    
}
