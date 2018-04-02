/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCExample;

/**
 *
 * @author ngsm
 */
public class TestStudent {
    public static void main(String[] args)
    {
        //Student s = new Student("B1011", "Joe", 60.5);
        StudentDA sda = new StudentDA();
      //  if (sda.save(s))
       //     System.out.println("Student data saved");
       Student aStudent = sda.getStudent("B1011");
       if (aStudent!=null)
            System.out.println(aStudent.toString());
       else
            System.out.println("No such student");
    }
}
