package TPC;

import java.util.*;

/**
 * TPC represents a Company (The Project Company)
 *
 * @author ngsm
 */
public class TPC {

    private int numberOfProjects;
    private Project[] tpcProjects;
    private final int MAX = 5;         // only 50 projects allowed!!

    private ArrayList<Employee> tpcEmployees;

    /**
     * Constructor to initialize the projects array
     */
    public TPC() {
        tpcProjects = new Project[MAX];
        numberOfProjects = 0;

        tpcEmployees = new ArrayList<>();
    }

    /**
     * add a project to TPC
     *
     * @param projectName name of the new project
     * @return the project that was created, null if not created.
     */
    public Project addProject(String projectName) {
        if (tpcProjects.length == numberOfProjects) // already full
        {
            return null;
        }
        Project newProj = new Project(projectName);
        tpcProjects[numberOfProjects++] = newProj;
        return newProj;         // return the project that was created

    }

    public ArrayList<Employee> getTpcEmployees() {
        return tpcEmployees;
    }

    public void setTpcEmployees() {
        if (tpcEmployees == null)
            tpcEmployees = new ArrayList<>();
    }

    // creates a Full Time Employee object and add to TPCEmployees[]
    public FullTimeEmployee addFullTimeEmployee(String name, double salary) {
        
        FullTimeEmployee fte = new FullTimeEmployee(name, salary);
        if (tpcEmployees.contains(fte))
            return null;
        else
        {
            tpcEmployees.add(fte);
            return fte;
        }
    }

// creates a Part Time Employee object and add to TPCEmployees[]	
    public PartTimeEmployee addPartTimeEmployee(String name, double hourlyRate) {
        
        PartTimeEmployee pte = new PartTimeEmployee(name, hourlyRate);
        // add to the array
        if (tpcEmployees.add(pte))
            return pte;
        return null;
    }

    /* findProject() method to return a project based on a project number.
     */
    public Project findProject(int projectNum) {

        for (int i = 0; i < numberOfProjects; i++) {
            if (tpcProjects[i].getProjectNum() == projectNum) {
                return tpcProjects[i];
            }
        }
        return null;
    }

    /* findProject() method to return a list of project numbers and names which 
	 * match a keyword entered.
     */
    public String findProject(String searchString) {
        String result = "Projects containing : '" + searchString + "'\n";
        for (int i = 0; i < numberOfProjects; i++) {
            if (tpcProjects[i].getProjectName().contains(searchString)) {
                result += tpcProjects[i].getProjectNum() + " " + tpcProjects[i].getProjectName() + "\n";
            }
        }
        return result;
    }

    /**
     * showAllProjects() method to return a list of all project numbers and
     * names
     */
    public String showAllProjects() {
        String result = "All Projects:\n";
        for (int i = 0; i < numberOfProjects; i++) {
            result += tpcProjects[i].getProjectNum() + " " + tpcProjects[i].getProjectName() + "\n";
        }
        return result;
    }

    public Employee findEmployee(int empNum)
    {
        for (int i = 0; i < tpcEmployees.size(); i++)
        {
            Employee e = tpcEmployees.get(i);
            if (e.getEmpNum()== empNum)
                return e;
        }
        return null;
        
    }
    
    /**
     * A method to calculate the total pay for ALL employees in TPC
     * @return 
     */
    public double totalPay()
    {
        double total = 0.09;
        Iterator<Employee> itr = tpcEmployees.iterator();
        while (itr.hasNext())
        {
            Employee e = itr.next();
            total += e.calculatePay();
        }
        return total;
    }
    
    /**
     * A method to find an employee based on a name
     * @param name
     * @return 
     */
    public Employee findEmployee(String name)
    {
        for(Employee e:tpcEmployees)
        {
            if (e.getName().equals(name))
                return e;
        }
        return null;
    }
}
