package TPC;

/**
 * User interface for TPC
 *
 * @author ngsm
 */
import java.util.*;

public class TPCConsole {

    static Scanner sc = new Scanner(System.in);
    static TPC tpc;

    public static void main(String[] args) {
        tpc = new TPC();
        char choice;
        do {
            System.out.println("1. Add new project");
            System.out.println("2. Find a project");
            System.out.println("3. Enter task for project");
            System.out.println("4. View project tasks");
            System.out.println("0. Quit");
            System.out.print("Enter choice :");
            choice = sc.nextLine().charAt(0);
            switch (choice) {
                case '1':
                    addNewProject();
                    break;
                case '2':
                    findProjects();
                    break;
                case '3':
                    enterTask();
                    break;
                case '4':
                    viewProjectTasks();
                    break;
                case '0':
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != '0');

    }

    /**
     * A method to add a task for a project
     */
    public static void viewProjectTasks() {
        System.out.print("Enter project number: ");
        int num = sc.nextInt();
        sc.nextLine();
        Project proj = tpc.findProject(num);
        if (proj == null) {
            System.out.println("Invalid project number");
        } else {
            System.out.println("Project found: " + proj.toString());
            System.out.println(proj.allTasks());
        }
    }

    /**
     * A method to add a task for a project
     */
    public static void enterTask() {
        System.out.print("Enter project number: ");
        int num = sc.nextInt();
        sc.nextLine();
        Project proj = tpc.findProject(num);
        if (proj == null) {
            System.out.println("Invalid project number");
        } else {
            System.out.println("Project found: " + proj.toString());
            System.out.print("Enter description of new task :");
            String desc = sc.nextLine();
            System.out.print("Enter estimated hours :");
            int hours = sc.nextInt();
            sc.nextLine();
            Task newT = proj.addTask(desc, hours);
            if (newT == null) {
                System.out.println("Task not added");
            } else {
                System.out.println("Task added to project");
            }
        }
    }

    /**
     * A method to add a new project to tpc
     */
    public static void addNewProject() {
        System.out.println("Adding a new project");
        System.out.print("Please enter project name :");
        String name = sc.nextLine();
        Project theProject = tpc.addProject(name);
        if (theProject == null) {
            System.out.println("Project not created");
        } else {
            System.out.println("Created :" + theProject.toString());
        }

    }

    /**
     * A method to show projects
     */
    public static void findProjects() {
        System.out.println("Enter project name wanted or press enter to show all");
        String wanted = sc.nextLine();
        if (wanted.isEmpty()) {
            System.out.println(tpc.showAllProjects());
        } else {
            System.out.println(tpc.findProject(wanted));
        }
    }
}
