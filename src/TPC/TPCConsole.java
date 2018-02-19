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
            System.out.println("5. Add Employee");
            System.out.println("6. Find Employee");
            System.out.println("7. Process Payroll");
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
                case '5':
                    addEmployee();
                    break;
                case '6':
                    findEmployee();
                    break;
                case '7':
                    processPayroll();
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
            int taskChoice;
            do {
                System.out.println("Would you like to:");
                System.out.println("1. assign task to employee");
                System.out.println("2. update task");
                System.out.println("0. return to main menu");
                taskChoice = sc.nextInt();
                sc.nextLine();
                switch (taskChoice) {
                    case 1:
                        assignTask(proj);
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu");
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            } while (taskChoice != 0);
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
     * A method to assign a task to an employee
     */
    public static void assignTask(Project p) {

        System.out.print("Enter task number");
        String taskNum = sc.nextLine();
        Task foundTask = p.findTask(taskNum);
        if (foundTask == null) {
            System.out.println("No such task number");
        } else {
            System.out.println("Task found");
            System.out.println(foundTask.toString());
            System.out.println("Enter name of employee to assign this task to");
            String empname = sc.nextLine();
            Employee foundEmp = tpc.findEmployee(empname);
            if (foundEmp == null) {
                System.out.println("No employee with this name");
            } else {
                if (foundEmp.addTask(foundTask)) {  // employee knows about this task
                    foundTask.setAssignedEmp(foundEmp);  // task knows about this Employee
                    System.out.println("Task added successfully");
                } else {
                    System.out.println("Task not added");
                }
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

    /**
     * A method to add a Employee to TPC
     */
    public static void addEmployee() {
        System.out.println("Do you want to add ");
        System.out.println("1. Full Time Employee");
        System.out.println("2. Part Time Employee");
        String choice = sc.nextLine();
        Employee newEmp = null;
        if (choice.equals("1")) {
            System.out.print("Enter Employee Name :");
            String empName = sc.nextLine();
            System.out.print("Enter Employee Monthly Salary :");
            double salary = sc.nextDouble();
            sc.nextLine();

            newEmp = tpc.addFullTimeEmployee(empName, salary);

        } else if (choice.equals("2")) {
            System.out.print("Enter Employee Name :");
            String empName = sc.nextLine();
            System.out.print("Enter Employee Hourly Rate :");
            double rate = sc.nextDouble();
            sc.nextLine();

            newEmp = tpc.addPartTimeEmployee(empName, rate);

        } else // not 1 or 2
        {
            System.out.println("Invalid choice");
        }

        if (newEmp != null) {
            System.out.println("Employee created: " + newEmp.toString());
        } else {
            System.out.println("Employee not created, name already exists");
        }
    }

    public static void findEmployee() {
        System.out.print("Enter employee name to find:");
        String wantedEmpName = sc.nextLine();
        Employee e = tpc.findEmployee(wantedEmpName);
        if (e == null) {
            System.out.println("No employee with this name");
        } else {
            System.out.println("Employee found : " + e.toString());
            System.out.println(e.assignedTasks());
            if (e instanceof PartTimeEmployee) {
                System.out.println("Do you want to enter Timesheet");
                char answer = sc.nextLine().charAt(0);
                if (answer == 'Y' || answer == 'y') {
                    System.out.print("Enter hours worked :");
                    int hours = sc.nextInt();
                    sc.nextLine();
                    if (((PartTimeEmployee) e).addTimesheet(hours)) {
                        System.out.println("Timesheet added");
                    } else {
                        System.out.println("Timesheet not added");
                    }
                }
            }

        }
    }

    public static void processPayroll() {
        double totalPayroll = tpc.totalPay();
        System.out.println("Total pay for all employees " + totalPayroll);
    }
}
