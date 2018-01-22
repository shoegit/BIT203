/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPC;

/**
 *
 * @author ngsm
 */
public class Task {
    
    private Project theProject;
    private String taskNum;
    private String description;
    private int estHours;
    private int actualHours;
    private TaskStatus status;

    public Task(Project theProject, String description, int estHours) {
        this.theProject = theProject;
        this.taskNum = "P"+ theProject.getProjectNum() + "-" + (theProject.getNumTasks()+1);
        this.description = description;
        this.estHours = estHours;
        this.actualHours =0;
        this.status = TaskStatus.OUTSTANDING;
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
    public String toString() {
        return "Task{" + "taskNum=" + taskNum + ", description=" + description + ", estHours=" + estHours + ", actualHours=" + actualHours + ", status=" + status + '}';
    }
    
}
