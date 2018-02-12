/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPC;

import java.util.ArrayList;

/**
 *
 * @author ngsm
 */
public class PartTimeEmployee extends Employee {

    private double hourlyRate;
    private ArrayList<Timesheet> ptTimesheets;

    // inner class Timesheet
    private class Timesheet {

        private int hoursWorked;
        private boolean isPaid;

        /**
         * no-args constructor, sets hours worked to 0 and isPaid to false
         */
        public Timesheet() {
            hoursWorked = 0;
            isPaid = false;
        }

        /**
         * constructor with arguments, sets isPAid to false
         *
         * @param hoursWorked
         */
        public Timesheet(int hoursWorked) {
            this.hoursWorked = hoursWorked;
            this.isPaid = false;
        }

        public int getHoursWorked() {
            return hoursWorked;
        }

        public void setHoursWorked(int hoursWorked) {
            this.hoursWorked = hoursWorked;
        }

        public boolean isPaid() {
            return isPaid;
        }

        public void setIsPaid(boolean isPaid) {
            this.isPaid = isPaid;
        }

        public String toString() {
            return "Hours worked " + hoursWorked + "is paid :" + isPaid;
        }

    }

    public PartTimeEmployee() {
        this("Unknown", 0.0);
    }

    public PartTimeEmployee(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
        ptTimesheets = new ArrayList<>();
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public boolean addTimesheet(int hoursWorked) {
        Timesheet t = new Timesheet(hoursWorked);
        return (ptTimesheets.add(t));
    }

    public int getTotalHoursWorked()
    {
        int totalHours = 0;
        for (Timesheet t:ptTimesheets)
            totalHours += t.getHoursWorked();
        return totalHours;
    }
    @Override
    public String toString() {
        return getName() + " with employee number " + getEmpNum() + " and hourly rate " + hourlyRate + " and has worked " + getTotalHoursWorked() + " hours";
    }

    public double calculatePay() {
        // get total hours from arraylist
        int totalHoursWorked = 0;
        for (Timesheet t : ptTimesheets) {
            if (!t.isPaid()) {
                totalHoursWorked += t.getHoursWorked();
                t.setIsPaid(true);
            }
        }
        return hourlyRate * totalHoursWorked;
    }
}
