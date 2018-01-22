package TPC;

/**
 * User interface for TPC
 * @author ngsm
 */
import java.util.*;
public class TPCConsole {
    
    static Scanner sc = new Scanner(System.in);
    static TPC tpc;
    
    public static void main(String[] args)
    {
        tpc = new TPC();
        char choice;
        do{
            System.out.println("1. Add new project");
            System.out.println("2. Find a project");
            System.out.println("3. Enter task for project");
            System.out.println("4. View project tasks");
            System.out.println("0. Quit");
            System.out.print("Enter choice :");
            choice = sc.nextLine().charAt(0);
            switch(choice)
            {
                case '1': addNewProject();break;
                case '2': findProjects(); break;
                case '0': System.out.println("Goodbye");break;
                default: System.out.println("Invalid choice");break;
            }
        } while (choice!='0');
        
    }
    
    /**
     * A method to add a new project to tpc
     */
    public static void addNewProject()
    {
        System.out.println("Adding a new project");
        System.out.print("Please enter project name :");
        String name = sc.nextLine();
        Project theProject = tpc.addProject(name);
        if (theProject == null)
            System.out.println("Project not created");
        else
            System.out.println("Created :" + theProject.toString());
        
    }
    
    /**
     * A method to show projects
     */
    public static void findProjects()
    {
        System.out.println("Enter project name wanted or press enter to show all");
        String wanted = sc.nextLine();
        if (wanted.isEmpty())
            System.out.println(tpc.showAllProjects());
        else
            System.out.println(tpc.findProject(wanted));
    }
}
