package agn;

import java.time.LocalDate;
import java.util.*;

/**
 * AGN represents the main class AGN AGN has a collection of donors and a
 * collection of children
 *
 * @author ngsm
 */
public class AGN {

    // AGN has a list of donors and a list of children
    private ArrayList<Donor> agnDonors;
    private ArrayList<Child> agnChildren;

    /**
     * Constructor to set up AGN
     */
    public AGN() {
        agnDonors = new ArrayList<>();
        agnChildren = new ArrayList<>();
    }

    /**
     * A method to find a donor given the email
     *
     * @param email
     * @return
     */
    public Donor findDonor(String email) {
        for (Donor d : agnDonors) {
            if (d.getEmail().equalsIgnoreCase(email)) {
                return d;
            }
        }
        return null;
    }

    /**
     * A method to find a child given the mykadno
     *
     * @param mykadNo
     * @return
     */
    public Child findChild(String myKadNo) {
        for (Child c : agnChildren) {
            if (c.getMyKadNo().equals(myKadNo)) {
                return c;
            }
        }
        return null;
    }

    /**
     * A method to add a Child to the collection The child cannot be added if
     * there is already a child with the same mykad
     *
     * @param childName
     * @param myKadNo
     * @param homeAddress
     * @param dateOfBirth
     * @return
     */
    public Child addChild(String childName, String myKadNo, String homeAddress, LocalDate dateOfBirth) {
        Child c = new Child(childName, myKadNo, homeAddress, dateOfBirth);
        if (agnChildren.contains(c)) // Child is already in agn
        {
            return null;
        }
        if (c.getAge() > 18) // too old!
        {
            return null;
        }
        if (agnChildren.add(c)) // try to add
        {
            return c;
        }
        return null;
    }

    /**
     * A method to add a donor to the collection The donor cannot be added if
     * there is already a donor with the same email address
     *
     * @param donorName
     * @param email
     * @return The donor object that was created
     */
    public Donor addDonor(String donorName, String email) {
        Donor d = new Donor(donorName, email);
        if (agnDonors.contains(d)) // Donor is already in agn
        {
            return null;
        }
        if (agnDonors.add(d)) {
            return d;
        }
        return null;
    }

    public ArrayList<Contribution> findContributionsBetween(LocalDate start, LocalDate end) {
        ArrayList<Contribution> found = new ArrayList<Contribution>();
        for (Donor d : agnDonors) {
            found.addAll(d.findContributionsBetween(start, end));
        }
        return found;
    }

    /**
     * 
     * @return a list of children without 100% sponsorship 
     */
    public String childrenNeedingSponsors() {
        boolean found = false;
        String children = " % \tAge\tMyKad Number\tName\n";
        for (Child c : agnChildren) {
            if (c.totalPercentageSponsored() < 100) {
                children += c.totalPercentageSponsored() + "\t" + c.getAge()+ "\t" + c.getMyKadNo()  + "\t" + c.getChildName()+"\n";
                found = true;
            }
        }
        if (found) {
            return children;
        }
        return "None";
    }
    
    public String showAllChildren()
    {
        String allKids = "Information on all children\n";
        for (Child c:agnChildren)
        {
            allKids += c.toString()+"\n";
        }
        return allKids;
    }
}
