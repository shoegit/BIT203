/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPC;

/**
 * A class to represent <code>Employee</code> objects.
 * An Employee has a empNum and name
 * @author ngsm
 */
public abstract class Employee {
    
    // instance variables
    private int empNum;
    private String name;
    private static int nextNo = 10000;
    
    public Employee()
    {
        empNum = nextNo++;
        name = "unknown";
    }
    
    public Employee(String name)
    {
        empNum = nextNo++;
        this.name = name;
    }

    public int getEmpNum() {
        return empNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    abstract public String toString();
    
    
}
