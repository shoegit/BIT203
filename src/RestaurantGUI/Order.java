/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantGUI;

import java.time.LocalDateTime;

/**
 * Order represents the orders that a customer will make
 * @author ngsm
 */
public class Order {
    private static int nextNo = 100;
    private int orderNo;
    private LocalDateTime ordertime;
    private String status;
    private int numPax;
    private Table theTable;
    
    public Order(Table theTable, int numPax)
    {
        orderNo = nextNo++;
        this.numPax = numPax;
        this.theTable = theTable;
        this.ordertime = LocalDateTime.now();
        this.status = "new";
    }

    public LocalDateTime getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(LocalDateTime ordertime) {
        this.ordertime = ordertime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumPax() {
        return numPax;
    }

    public void setNumPax(int numPax) {
        this.numPax = numPax;
    }

    public Table getTheTable() {
        return theTable;
    }

    public void setTheTable(Table theTable) {
        this.theTable = theTable;
    }

    public String toString()
    {
        return "Order " + orderNo + " for Table " + theTable.getTableNo() + " created at " + ordertime.toString();
    }
    
   
}
