package TPC;

import java.util.*;

/**
 * A class to represent <code>Project</code> objects. A Project has a
 * projectName and projectNum
 *
 * @version 2.0 Modified: 22/1/2018
 * @author ngsm
 */
public class Project implements Comparable<Project>, Cloneable{

    private String projectName;
    private int projectNum;
    private static int nextProjectNo = 0;
    
    private ArrayList<Task> projectTasks;    // all the tasks for this project
    

    /**
     * Constructor to set the project Name and generate project number
     *
     * @param projectName
     */
    public Project(String projectName) {
        if (projectName.isEmpty()) {
            this.projectName = "undefined";
        } else {
            this.projectName = projectName;
        }
        this.projectNum = ++nextProjectNo;
        
        // initialize the array of tasks
        projectTasks = new ArrayList<>();
        
    }

    public int getNumTasks() {
        return projectTasks.size();
    }
    
    /**
     * A method that returns info about all tasks in a String
     * @return String containing task info
     */
    public String allTasks()
    {
        if (getNumTasks() == 0)
            return "No tasks defined yet";
        String results = "All Tasks for This Project\n";
        for (Task t:projectTasks)
            results += t.toString() + "\n";
        return results;
    }

    /**
     * getter for the project name
     *
     * @return name of the project
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * setter for the project name
     *
     * @param projectName the name of the project should be less than 30
     * characters
     */
    public void setProjectName(String projectName) {
        if (!projectName.isEmpty()) {
            this.projectName = projectName;
        }
    }

    /**
     * getter for the project number
     *
     * @return projectNum
     */
    public int getProjectNum() {
        return projectNum;
    }

    /** A method to add a Task to a project
     * 
     * @param description
     * @param estHours
     * @return Task that was created
     */
    public Task addTask(String description, int estHours)
    {
       Task newTask = new Task(this, description, estHours);
       if (projectTasks.contains(newTask))
           return null;     // task already exists
       if (projectTasks.add(newTask))
              return newTask;
        return null;
    }
    
    /**
     * A method to find a task from a project
     * @param tasknum
     * @return Task with the matching tasknum, or null if not found
     */
    public Task findTask(String tasknum)
    {
        for(Task t:projectTasks)
        {
            if (t.getTaskNum().equalsIgnoreCase(tasknum))
                return t;
        }
        return null;
    }
    
    /**
     * equals method for Project
     * checks that a project is equal to another if they have the same name
     * @param obj the other object to compare
     * @return true if two projects have the same name, false otherwise
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!(obj instanceof Project))
            return false;
        Project otherProject = (Project) obj;
        if (this.getProjectName().equalsIgnoreCase(otherProject.getProjectName()))
               return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.projectName.toLowerCase());
        return hash;
    }
    /**
     * toString method
     *
     * @return information about the project
     */
    @Override
    public String toString() {
        return "Project{" + "projectName=" + projectName + ", projectNum=" + projectNum + '}';
    }

    /**
     * overriding the Object.clone() method to clone a project
     * @return the clone of the project  
     */
    @Override
    public Object clone()
    {
       try
       {
           return super.clone();
       }
       catch (CloneNotSupportedException e)
       {
           return null;
       }
               
    }
    
    @Override
    public int compareTo(Project t) {
        return this.getProjectName().toLowerCase().compareTo(t.getProjectName().toLowerCase());
    }

}
