/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture9;
import java.awt.event.*;
/**
 *
 * @author ngsm
 */
public class WindowCloser implements WindowListener{

    @Override
    public void windowOpened(WindowEvent we) {   }

    @Override
    public void windowClosing(WindowEvent we) {
        we.getWindow().dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent we) {}

    @Override
    public void windowIconified(WindowEvent we) {  }

    @Override
    public void windowDeiconified(WindowEvent we) {}

    @Override
    public void windowActivated(WindowEvent we) {    }

    @Override
    public void windowDeactivated(WindowEvent we) {}
    
}
