package agn;
import java.time.LocalDate;
import java.util.*;
/**
 *
 * @author ngsm
 */
public class Child {
    
    // Instance variables
    private String childName;
    private String MyKadNo;
    private String homeAddress;
    private LocalDate dateOfBirth;
    // A array list to store all the sponsorship belong to thos child
    private ArrayList<Sponsorship> childSponsorships;
    
    /**
     * Constructor
     * @param childName
     * @param MyKadNo
     * @param homeAddress
     * @param dateOfBirth 
     */
    public Child(String childName, String MyKadNo, String homeAddress, LocalDate dateOfBirth) {
        if (!(childName.isEmpty()))
            this.childName = childName;
        if (!(MyKadNo.isEmpty()))
            this.MyKadNo = MyKadNo;
        if (!(homeAddress.isEmpty()))
            this.homeAddress = homeAddress;
        this.dateOfBirth = dateOfBirth;
        childSponsorships = new ArrayList<>();     
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getMyKadNo() {
        return MyKadNo;
    }

    public void setMyKadNo(String MyKadNo) {
        this.MyKadNo = MyKadNo;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<Sponsorship> getChildSponsorships() {
        return childSponsorships;
    }

    public void setChildSponsorships(ArrayList<Sponsorship> childSponsorships) {
        this.childSponsorships = childSponsorships;
    }
    
    /**
     * A method to store a sponsorship belong to this child to the child sponsorship list
     * @param s 
     */
    public void addSponsorshipToChild(Sponsorship s) {
        childSponsorships.add(s);
    }

    /**
     * A method to calculate the total percentage sponsored for a child
     * @return the total percentage sponsored
     */
    public int totalPercentageSponsored() {
        int total = 0;
        for (Sponsorship aSponsorship : childSponsorships)
            total += aSponsorship.getPercentage();
        return total;
    }
    
    /**
     * A method to calculate the current age for a child
     * @return the age of child
     */
    public int getAge() {
        int age = LocalDate.now().getYear() - dateOfBirth.getYear();
        return age;
    }
    
    @Override
    public String toString() {
        String result = "Child {child name = " + getChildName() + ", mykad no = " + getMyKadNo();
        result += ", age = " + getAge() + ", home address = " + getHomeAddress();
        result += "% Sponsored " + totalPercentageSponsored() + " }";
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * 
     * @param obj
     * @return 
     */
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
        final Child other = (Child) obj;
        if (!Objects.equals(this.MyKadNo, other.MyKadNo)) {
            return false;
        }
        return true;
    }
    
   
    
    public String showSponsorshipInfo()
    {
        String results = "Donor : Email\t % sponsored +\t Value\n";
        for (Sponsorship s:childSponsorships)
                results += s.getTheDonor().toString() + "\t"+s.getPercentage() + "\t" + s.getValue() +"\n";
        return results;
    }
}
