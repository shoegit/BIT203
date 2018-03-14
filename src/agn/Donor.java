package agn;

import java.util.*;
import java.time.*;

/**
 *
 * @author ngsm
 */
public class Donor {

    // Instance variables
    private String donorName;
    private String email;
    // To store the contributions contributed by donor
    private ArrayList<Contribution> donorContributions;

    /**
     * Constructor
     *
     * @param donorName
     * @param email
     */
    public Donor(String donorName, String email) {
        if (!donorName.isEmpty()) {
            this.donorName = donorName;
        }
        if (!email.isEmpty()) {
            this.email = email;
        }
        donorContributions = new ArrayList<>();
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * A method to calculate the total contributions contribute by donor
     *
     * @return the total contribution value
     */
    public double totalContributionValue() {
        double total = 0.00;
        for (Contribution c : donorContributions) {
            total += c.getValue();
        }
        return total;
    }

    /**
     * A method to add the Material contributed by donor to the donor
     * contribution list
     *
     * @param date
     * @param category
     * @param itemDescription
     * @param valuePerUnit
     * @param numUnitsContributed
     * @return Material if it was added successfully, null otherwise
     */
    public Material addMaterial(LocalDate date, MaterialType category, String itemDescription, double valuePerUnit, int numUnitsContributed) {
        Material newMaterial = new Material(date, category, itemDescription, valuePerUnit, numUnitsContributed);
        if (donorContributions.add(newMaterial)) {
            return newMaterial;
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

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
        final Donor other = (Donor) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    /**
     * A method to add the Monetary contributed by donor to the donor
     * contribution list
     *
     * @param date
     * @param donationAmount
     * @return Monetary if it was added successfully, null otherwise
     */
    public Monetary addMonetary(LocalDate date, double donationAmount) {
        Monetary newMonetary = new Monetary(date, donationAmount);
        if (donorContributions.add(newMonetary)) {
            return newMonetary;
        }
        return null;
    }

    /**
     * A method to add the Sponsorship contributed by donor to the donor
     * contribution list
     *
     * @param date
     * @param percentage
     * @return Sponsorship if it was added successfully, null otherwise
     */
    public Sponsorship addSponsorship(LocalDate date, int percentage) {
        Sponsorship newSponsorship = new Sponsorship(date, percentage);
        if (donorContributions.add(newSponsorship)) {
            return newSponsorship;
        }
        return null;
    }

    /**
     * A method to retrieve the donor contributions list
     *
     * @return the donor contributions list
     */
    public ArrayList<Contribution> getDonorContributions() {
        return donorContributions;
    }

    /**
     * A method to find all contributions between specified dates
     *
     * @param start
     * @param end
     * @return arraylist containing contributions made between the given dates
     */
    public ArrayList<Contribution> findContributionsBetween(LocalDate start, LocalDate end) {
        ArrayList<Contribution> found = new ArrayList<Contribution>();
        for (Contribution c : donorContributions) {
            LocalDate conDate = c.getDate();
            if (!conDate.isBefore(start) && !conDate.isAfter(end)) {
                found.add(c);
            }
        }
        return found;
    }

    @Override
    public String toString() {
        return donorName + ":" + email ;
    }
}
