/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPC;

import java.util.Objects;

/**
 * A class for representing Tasks of a Project
 * @author ngsm
 */
public class Task implements Comparable<Task> {
    
    private Project theProject;
    private String taskNum;
    private String description;
    private int estHours;
    private int actualHours;
    private TaskStatus status;
    private Employee assignedEmp;

    public Task(Project theProject, String description, int estHours) {
        this.theProject = theProject;
        this.taskNum = "P"+ theProject.getProjectNum() + "-" + (theProject.getNumTasks()+1);
        this.description = description;
        this.estHours = estHours;
        this.actualHours =0;
        this.status = TaskStatus.OUTSTANDING;
        this.assignedEmp = null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstHours() {
        return estHours;
    }

    public void setEstHours(int estHours) {
        this.estHours = estHours;
    }

    public int getActualHours() {
        return actualHours;
    }

    public void setActualHours(int actualHours) {
        this.actualHours = actualHours;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getTaskNum() {
        return taskNum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.taskNum);
        hash = 89 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.taskNum, other.taskNum)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    
   
    

    @Override
    public String toString() {
        return "Task{" + "taskNum=" + taskNum + ", description=" + description + ", estHours=" + estHours + ", actualHours=" + actualHours + ", status=" + status + '}';
    }

    @Override
    public int compareTo(Task t) {
        return this.taskNum.compareTo(t.taskNum);
    }
    
}
