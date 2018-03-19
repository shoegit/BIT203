/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ngsm
 */
public class StudentListGUI extends JFrame implements ActionListener{
    
    private JTextField nameTF;
    private JTextField studentIDTF;
    private JTextField scoreTF;
    private JButton addButton;
    private JButton removeButton;
    private JList list;
    private DefaultListModel listModel;
    
    public StudentListGUI()
    {
        this.setTitle("Student List");
        JPanel labelsPanel = new JPanel(new GridLayout(0,1,0,8));
        labelsPanel.add(new JLabel("Student Name"));
        labelsPanel.add(new JLabel("StudentID"));
        labelsPanel.add(new JLabel("Score"));
        
        JPanel fieldsPanel = new JPanel(new GridLayout(0,1,0,8));
        nameTF = new JTextField(10);
        studentIDTF = new JTextField(10);
        scoreTF = new JTextField(10);
        fieldsPanel.add(nameTF);
        fieldsPanel.add(studentIDTF);
        fieldsPanel.add(scoreTF);
        
         JPanel buttonsPanel = new JPanel(new GridLayout(0,1,0,8));
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        buttonsPanel.add(addButton);
        buttonsPanel.add(removeButton);
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(labelsPanel);
        topPanel.add(fieldsPanel);
        topPanel.add(buttonsPanel);
    
        JPanel listPanel = new JPanel(new GridLayout(0,1,0,8));
        listModel = new DefaultListModel();
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listPanel.add(topPanel);
        listPanel.add(list);
        
        this.getContentPane().add(listPanel, "North");
        
        this.setSize(400,200);
       }
    
    public static void main(String[] args)
    {
        StudentListGUI slg = new StudentListGUI();
        slg.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==addButton)
        {
            String name = nameTF.getText();
            String studentID = studentIDTF.getText();
            double score = Double.parseDouble(scoreTF.getText());
            Student s = new Student(name, studentID, score);
            if (listModel.contains(s))
                JOptionPane.showMessageDialog(this, "Student already exists");
            else
                listModel.addElement(s);
        }
        if (ae.getSource()==removeButton)
        {
            int num = list.getSelectedIndex();
            if (num >= 0)
                listModel.remove(num);
            else
                JOptionPane.showMessageDialog(this, "you must select a student first");
        }
    }
}
