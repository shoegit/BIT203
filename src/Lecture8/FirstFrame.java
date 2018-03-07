/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture8;
import java.awt.FlowLayout;
import javax.swing.*;
/**
 *
 * @author ngsm
 */
public class FirstFrame {
    
    public static void main(String[] args)
    {
        JFrame jf = new JFrame("First frame");
        jf.setSize(500,300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout());
        JLabel nameLbl = new JLabel("Name");
        JTextField nameTF = new JTextField(10);
        JButton OKbtn = new JButton("OK");
             
        jf.add(OKbtn);
        jf.add(nameLbl);
        jf.add(nameTF);
         jf.setVisible(true);
    }
}
