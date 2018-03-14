/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agn;

import java.util.*;
import java.time.*;
import java.time.format.*;

/**
 * AGN with menu to record children and contributions
 *
 * @author ngsm
 */
public class AGNConsole {

    static Scanner sc = new Scanner(System.in);
    static AGN agn;

    public static void main(String[] args) {
        agn = new AGN();
        char choice;
        do {
            System.out.println("1. Record Child");
            System.out.println("2. Record Contribution");
            System.out.println("3. View Contribution Records");
            System.out.println("4. View Sponsorship Records");
            System.out.println("0. Quit");
            System.out.print("Enter choice :");
            choice = sc.nextLine().charAt(0);
            switch (choice) {
                case '1':
                    addChild();
                    break;
                case '2':
                    addContribution();
                    break;
                case '3':
                    viewContributionRecords();
                    break;
                case '4':
                    viewSponsorshipRecords();
                    break;
                case '5':
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
     * A method to add a child for a project ot sufficiently validated yet!
     */
    public static void addChild() {

        System.out.println("Recording a new Child");
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("d/M/y");

        LocalDate birthdate = null;
        String name = "";
        String myKad = "";
        String address = "";
        boolean valid = false;
        do {
            try {
                System.out.print("Enter MyKad number  :");
                myKad = sc.nextLine();
                if (agn.findChild(myKad) != null) {
                    throw new Exception("Child already exists");
                }
                System.out.print("Enter child's name :");
                name = sc.nextLine();
                System.out.print("Enter child's date of birth as dd/mm/yyyy :");
                String date = sc.nextLine();
                birthdate = LocalDate.parse(date, dateformat);
                valid = true;
                if (birthdate.isAfter(LocalDate.now())) {
                    throw new Exception("Birthday cannot be after today");
                }
                if (LocalDate.now().getYear() - birthdate.getYear() > 18) {
                    throw new Exception("Child must be under 18");
                }
                System.out.print("Enter home address  :");
                address = sc.nextLine();
                valid = true;
            } catch (DateTimeParseException dtpe) {
                System.out.println("Invalid date entered, please re-enter date as dd/mm/yyyy");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!valid);

        Child c = agn.addChild(name, myKad, address, birthdate);
        if (c != null) {
            System.out.println("Child added : " + c.toString());
        } else {
            System.out.println("Error, Child not added");
        }
    }

    /**
     * A method to add a donor and contribution for a project. Not sufficiently
     * validated yet!
     */
    public static void addContribution() {

        System.out.println("Recording a new Contribution");
        System.out.print("Enter donor email :");
        String email = sc.nextLine();
        Donor d = agn.findDonor(email);
        if (d != null) {
            System.out.println("Donor found :" + d.toString());
            System.out.println("Contributions made " + d.totalContributionValue());
        } else {
            System.out.println("New Donor");
            System.out.println("Enter donor's name :");
            String name = sc.nextLine();
            d = agn.addDonor(name, email);
            if (d == null) {
                System.out.println("Donor not added");
            }
        }
        if (d != null) {
            recordContributionForDonor(d);

        }
    }

    /**
     * A method to record a contribution for a donor
     *
     * @param d the donor who makes the contribution
     */
    public static void recordContributionForDonor(Donor d) {
        System.out.println("Choose contribution type");
        System.out.println("1. Material");
        System.out.println("2. Monetary");
        System.out.println("3. Sponsorship");
        char type = sc.nextLine().charAt(0);
        while (type < '1' || type > '3') {
            System.out.println("Invalid contribution type");
            type = sc.nextLine().charAt(0);
        }
        Contribution theContribution = null;
        if (type == '1') // Material
        {
            System.out.print("Enter contribution date ");
            LocalDate condate = readDateFromUser();
            MaterialType mt = MaterialType.CLOTHING;
            System.out.print("Enter description of item");
            String desc = sc.nextLine();
            boolean ok = true;
            do {
                ok = true;
                try {
                    System.out.println("What material would you like ?");
                    System.out.println("0. School Supplies");
                    System.out.println("1. Food");
                    System.out.println("2. Clothing");
                    System.out.print("Enter 0, 1 or 2:");
                    int choice = sc.nextInt();
                    mt = MaterialType.values()[choice];
                } catch (Exception e) {
                    System.out.println("Invalid material type");
                    ok = false;
                }
            } while (!ok);
            System.out.print("Enter value per unit of material");
            double valPerUnit = sc.nextDouble();
            System.out.print("Enter number of units of material");
            int numUnits = sc.nextInt();
            sc.nextLine();
            theContribution = d.addMaterial(condate, mt, desc, valPerUnit, numUnits);

        } else if (type == '2') {
            System.out.print("Enter contribution date ");
            LocalDate condate = readDateFromUser();

            System.out.print("Enter amount of Monetary contribution");
            double amount = sc.nextDouble();
            sc.nextLine();
            theContribution = d.addMonetary(condate, amount);
        } else // type is Sponsorship
        {
            String children = agn.childrenNeedingSponsors();
            if (children.equals("None")) {
                System.out.println("No children need sponsors");
            } else {
                System.out.println("Children who need Sponsors");
                System.out.println(children);
                System.out.print("Enter contribution date ");
                LocalDate condate = readDateFromUser();

                System.out.println("Enter child's MyKad No");
                String myKad = sc.nextLine();
                Child c = agn.findChild(myKad);
                if (c == null) {
                    System.out.println("No such child");
                } else if (c.totalPercentageSponsored() >= 100) {
                    System.out.println("Child is already fully sponsored");
                } else {
                    System.out.print("Enter % of sponsorship (0 - 100)");
                    int percent = sc.nextInt();
                    sc.nextLine();
                    Sponsorship s = d.addSponsorship(condate, percent);
                    if (s != null) {
                        c.addSponsorshipToChild(s);
                        theContribution = s;
                    }
                }
            }
        }
        if (theContribution != null) // a contribution was created
        {
            System.out.println("Contribution added " + theContribution.toString());
            theContribution.setTheDonor(d);
        }
    }

    /**
     * A method to view all contribution records between two dates
     */
    public static void viewContributionRecords() {
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("d/M/y");

        System.out.print("Enter start date :");
        LocalDate startDate = readDateFromUser();
        System.out.print("Enter end date");
        LocalDate endDate = readDateFromUser();
        ArrayList<Contribution> contributions = agn.findContributionsBetween(startDate, endDate);
        if (contributions == null) {
            System.out.println("No Contributions between these dates");
        } else {
            int sortStyle = 0;

            do {
                System.out.println("Would you like to sort by ");
                System.out.println("1. Date");
                System.out.println("2. Value");
                System.out.println("3. Contribution Type");
                System.out.println("0. Quit");
                sortStyle = sc.nextInt();
                sc.nextLine();
                if (sortStyle == 1) {
                    Collections.sort(contributions);
                } else if (sortStyle == 2) {
                    Collections.sort(contributions, new ValueComparator());
                } else if (sortStyle == 3) {
                    Collections.sort(contributions, new ConTypeComparator());
                }
                for (Contribution c : contributions) {
                    System.out.println(c.toString());
                }
            } while (sortStyle != 0);
        }
    }

    /**
     * A helper method to read dates
     *
     * @return Local Date in dd/mm/yyyy format
     */
    public static LocalDate readDateFromUser() {
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("d/M/y");

        LocalDate userdate = null;
        boolean valid = false;
        do {
            try {
                System.out.print("( as dd/mm/yyyy   :");
                String date = sc.nextLine();
                userdate = LocalDate.parse(date, dateformat);
                valid = true;
            } catch (DateTimeParseException dtpe) {
                System.out.println("Invalid date entered, please re-enter date as dd/mm/yyyy");

            }
        } while (!valid);
        return userdate;
    }

    /**
     * A method to view all sponsorships
     */
    public static void viewSponsorshipRecords() {
        System.out.println(agn.showAllChildren());
        System.out.println("View details of a Child ");
        System.out.print("Enter MyKadNo :");
        String myKad = sc.nextLine();
        Child c = agn.findChild(myKad);
        if (c == null) {
            System.out.println("No child with this MyKadNo");
        } else if (c.totalPercentageSponsored() == 0) {
            System.out.println("This child has no sponsorships");
        } else {
            System.out.println(c.showSponsorshipInfo());
        }

    }

}
