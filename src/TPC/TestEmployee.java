/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPC;

import java.util.*;

public class TestEmployee {

    /**
     * @param args
     */
    public static void main(String[] args) {

        ArrayList<Employee> emp = new ArrayList<>();
        emp.add(new FullTimeEmployee("Joe", 100));
        emp.add(new PartTimeEmployee("Mike", 10.4));
        emp.add(new FullTimeEmployee("Ali", 1000));
        emp.add(new FullTimeEmployee("Baba", 200));
        emp.add(new PartTimeEmployee("Jack", 10.3));
        emp.add(new FullTimeEmployee("Charlie", 1000));

        for (Employee e : emp) {
            System.out.println(e.toString());
        }

        System.out.println("Sorting by name");
        Collections.sort(emp);
        for (Employee e : emp) {
            System.out.println(e.toString());
        }
        
        System.out.println("Sort by Pay");
        // sort by pay
        Collections.sort(emp, new PayComparator());
         for (Employee e : emp) {
            System.out.println(e.toString());
        }
    }
}
