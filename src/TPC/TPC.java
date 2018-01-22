
package TPC;

/**
 * TPC represents a Company (The Project Company)
 * @author ngsm
 */
public class TPC {
    
    private int numberOfProjects;
    private Project[] tpcProjects;
    private final int MAX = 5;         // only 50 projects allowed!!
    
    /** 
     * Constructor to initialize the projects array
     */
    public TPC()
    {
        tpcProjects = new Project[MAX];
        numberOfProjects = 0;
    }
    
    /**
     * add a project to TPC
     * @param projectName name of the new project
     * @return the project that was created, null if not created.
     */
    public Project addProject(String projectName)
    {
        if (tpcProjects.length== numberOfProjects)   // already full
            return null;
        Project newProj = new Project(projectName);
        tpcProjects[numberOfProjects++] = newProj;
        return newProj;         // return the project that was created
        
    }
}
