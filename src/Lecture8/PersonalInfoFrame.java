/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture8;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ngsm
 */
public class PersonalInfoFrame extends JFrame {
    
    public PersonalInfoFrame()
    {
        // set up the GUI
        this.setSize(200,200);
        this.setTitle("Personal Information");
        
        // First BLUE panel
        JPanel p1 = new JPanel(new GridLayout(0,1,0,8));
        JLabel nameLbl = new JLabel("Name");
        JLabel heightLbl = new JLabel("Height");
        JLabel weightLbl = new JLabel("Weight");
        p1.add(nameLbl);
        p1.add(heightLbl);
        p1.add(weightLbl);
       
        // Second BLUE Panel
        JPanel p2 = new JPanel(new GridLayout(0,1,0,8));
        JTextField nameTF = new JTextField(10);
        JTextField heightTF = new JTextField(10);
        JTextField widthTF = new JTextField(10);
        p2.add(nameTF);
        p2.add(heightTF);
        p2.add(widthTF);
        
        // First RED Panel
        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(p1);
        p3.add(p2);
        
        // Second RED Panel
        JPanel p4 = new JPanel(new FlowLayout());
        JButton submitBtn = new JButton("Submit");
        JButton cancelBtn = new JButton("Cancel");
        p4.add(submitBtn);
        p4.add(cancelBtn);
        
        // One more panel
        JPanel p5 = new JPanel(new GridLayout(0,1));
        p5.add(p3);
        p5.add(p4);
        
        this.add(p5, BorderLayout.NORTH);
        
    }
    
    public static void main(String[] args)
    {
        PersonalInfoFrame pif = new PersonalInfoFrame();
        pif.setVisible(true);
    }
}
