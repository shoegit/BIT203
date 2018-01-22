package TPC;

/**
 * A class to represent <code>Project</code> objects. A Project has a
 * projectName and projectNum
 *
 * @version 2.0 Modified: 22/1/2018
 * @author ngsm
 */
public class Project {

    private String projectName;
    private int projectNum;
    private static int nextProjectNo = 0;

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

    /**
     * toString method
     *
     * @return information about the project
     */
    @Override
    public String toString() {
        return "Project{" + "projectName=" + projectName + ", projectNum=" + projectNum + '}';
    }

}
