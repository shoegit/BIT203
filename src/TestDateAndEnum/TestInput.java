/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDateAndEnum;

import java.util.*;
import java.time.*;
import java.time.format.*;

/**
 *
 * @author ngsm
 */
public class TestInput {

    static Scanner sc;
    
    public static void main(String[] args) {
         sc = new Scanner(System.in);
         findAge();
         chooseMaterial();
         
    }
    
    /**
     * A method to show the age of a person based on the birthdate
     */
    public static void findAge()
    {
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
    
    public static void chooseMaterial()
    {
        System.out.println("What material would you like ?");
        System.out.println("0. School Supplies");
        System.out.println("1. Food");
        System.out.println("2. Clothing");
        System.out.print("Enter 0, 1 or 2:");
        int choice = sc.nextInt();
        MaterialType mt = MaterialType.values()[choice];
        System.out.println("You selected " + mt);
        
        // another way to select
        System.out.println("Really, what material would you like?");
        System.out.print("Enter 'schoolsupplies', 'food' or 'clothing' :");
        String type = sc.next();
        mt = MaterialType.valueOf(type.toUpperCase()); // must make uppercase
        System.out.println("This time you selected " + mt);
    }
}
