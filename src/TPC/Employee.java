/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPC;

import java.util.ArrayList;

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
    private ArrayList<Task> empTasks;
    
    
    public Employee()
    {
        empNum = nextNo++;
        name = "unknown";
        empTasks = new ArrayList<>();
    }
    
    public Employee(String name)
    {
        empNum = nextNo++;
        this.name = name;
        empTasks = new ArrayList<>();
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
    
    /**
     * A method to show all the tasks this employee has been assigned
     * @return 
     */
    public String assignedTasks()
    {
        if (empTasks.size()==0)
            return "No tasks assigned";
        String taskList = "Tasks assigned to this employee\n";
        for(Task t:empTasks)
        {
            taskList += t.getTaskNum() + " " + t.getDescription() + "\n";
        }
        return taskList;
    }
    
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
    
    public boolean addTask(Task newTaskForThisEmp)
    {
        if(empTasks.contains(newTaskForThisEmp))
            return false;
        return empTasks.add(newTaskForThisEmp);
    }
    
    @Override
    public int compareTo(Employee obj)
    {
        if (this == obj)    // same object
            return 0;
        return (this.getName().compareTo(obj.getName()));
    }
}
