package TPC;

import java.util.Objects;

/**
 * A class to represent <code>Project</code> objects. A Project has a
 * projectName and projectNum
 *
 * @version 2.0 Modified: 22/1/2018
 * @author ngsm
 */
public class Project implements Comparable<Project>{

    private String projectName;
    private int projectNum;
    private static int nextProjectNo = 0;
    
    private int numTasks;   // the number of tasks in the project
    private Task[] projectTasks;    // all the tasks for this project
    private final int MAXTASKS = 50;
    

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
        projectTasks = new Task[MAXTASKS];
        numTasks = 0;
    }

    public int getNumTasks() {
        return numTasks;
    }
    
    /**
     * A method that returns info about all tasks in a String
     * @return String containing task info
     */
    public String allTasks()
    {
        if (numTasks == 0)
            return "No tasks defined yet";
        String results = "All Tasks for This Project";
        for (int i = 0; i < numTasks; i++)
            results += this.projectTasks[i].toString() + "\n";
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
        if (projectTasks.length == numTasks)
            return null;
        Task newTask = new Task(this, description, estHours);
        projectTasks[numTasks++] = newTask;
        return newTask;
    }
    
    
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

    
    @Override
    public int compareTo(Project t) {
        return this.getProjectName().toLowerCase().compareTo(t.getProjectName().toLowerCase());
    }

}
