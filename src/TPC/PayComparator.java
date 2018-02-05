/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPC;

import java.util.Comparator;

/**
 *
 * @author ngsm
 */
public class PayComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
        // if employee 1 pay is lower return -ve
        if (e1.calculatePay() > e2.calculatePay())
            return -1;
        else if (e2.calculatePay() > e1.calculatePay()) 
            return 1;
        else
            return 0;
    }
    
}
