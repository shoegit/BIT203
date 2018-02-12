/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPC;

/**
 *
 * @author ngsm
 */
public class TestCloning {
    
    public static void main(String[] args)
    {
        Project p1 = new Project("BIT203 cloning experiment");
        Project p2 = (Project) p1.clone();
        Project p3 = p1;    // refer to the same object
        
        System.out.println("P1 is " + p1);
        System.out.println("P2 is " + p2);
        p2.setProjectName("Different name");
        p3.setProjectName("now this is P3");

        System.out.println("P1 is " + p1);
        System.out.println("P2 is " + p2);
    }
}
