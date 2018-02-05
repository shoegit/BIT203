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
public abstract class Employee implements Comparable<Employee>{
    
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
    
    /**
     * A method to calculate the pay for an employee
     * @return the pay that is due to the employee
     */
    abstract public double calculatePay();
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!(obj instanceof Employee))
            return false;
        Employee rhs = (Employee) obj;
        // two employees are equal if they have the same name
        // demonstration only
        if (this.getName().equals(rhs.getName()))
            return true;
        else
            return false;
    }
    
    @Override
    public int compareTo(Employee obj)
    {
        if (this == obj)    // same object
            return 0;
        return (this.getName().compareTo(obj.getName()));
    }
}
