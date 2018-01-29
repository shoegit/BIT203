/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPC;

public class TestEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		// create an Employee object with the no-args constructor
		Employee e1; // = new Employee();
		
		// create an Employee object with the constructor with arguments
		Employee e2; //= new Employee("Zi Yuan");
				
		// create a Full Time Employee object with the no-args constructor
		FullTimeEmployee fe1 = new FullTimeEmployee();
						
// create a Full Time Employee object with the constructor with arguments.
		FullTimeEmployee fe2 = new FullTimeEmployee("Suet Kee", 5000.0);					
		
					
		// try to use the toString() methods.
             //   System.out.println(e1.toString());
          //      System.out.println(e2.toString());
                System.out.println(fe1.toString());
                System.out.println(fe2.toString());
                
 		// set the name for e1 
         //       e1.setName("Joe Ee");
                
		// set the name for fe1 – is it used the same way as for e1?
		fe1.setName("Jim Ee");
		// use the getters to show the employee numbers for all employees
		
                System.out.println("E1 emp num: " + e1.getEmpNum());
                System.out.println("FE1 emp num" + fe1.getEmpNum());
		// can you assign fe1 to e1? Why/why not?
		e1 = fe1;
                e1.getName();
		// can you assign e1 to fe1? Why/why not?
		fe1 = (FullTimeEmployee) e1;
	}

}

