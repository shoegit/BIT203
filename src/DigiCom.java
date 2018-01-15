/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ngsm
 */
public class DigiCom {
    public static void main(String []args)
    {
        // Modify this program to answer Question 8 as homework
        Worker worker1 = new Worker();
        worker1.setName("Omran");
        System.out.println("Worker 1 name is " + worker1.getName());
        System.out.println(worker1.toString());
        
        System.out.println("Worker overtime rate is ");
        System.out.println(Worker.OVERTIMERATE);
        System.out.println(worker1.OVERTIMERATE);
        Worker worker2 = new Worker();
        System.out.println(worker1.OVERTIMERATE);
      
    }
}
