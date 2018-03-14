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
 *
 * @author ngsm
 */
public class SetupDates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("d/M/y");
        LocalDate birthdate = null;
        boolean valid = false;
        do {
            try {
                System.out.println("What is your date of birth?");

                System.out.print("Enter session date as dd/mm/yyyy :");
                String date = sc.nextLine();
                birthdate = LocalDate.parse(date, dateformat);
                valid = true;
                if (birthdate.isAfter(LocalDate.now())) {
                    System.out.println("Birthday cannot be after today");

                    valid = false;
                }

            } catch (DateTimeParseException dtpe) {
                System.out.println("Invalid date entered, please re-enter date as dd/mm/yyyy");
            }
        } while (!valid);
        if (birthdate != null) {
            int age = LocalDate.now().getYear() - birthdate.getYear();
            System.out.println("You are " + age + " years old this year");
        }
    }
}
