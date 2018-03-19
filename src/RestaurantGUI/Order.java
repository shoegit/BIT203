/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantGUI;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
    private ArrayList<OrderItem> orderedItems;
    
    public Order(Table theTable, int numPax)
    {
        orderNo = nextNo++;
        this.numPax = numPax;
        this.theTable = theTable;
        this.ordertime = LocalDateTime.now();
        this.status = "new";
        this.orderedItems = new ArrayList<>();
    }

    public LocalDateTime getOrdertime() {
        return ordertime;
    }

    public OrderItem addItem(MenuItem mi, int quantity, String request)
    {
        OrderItem oi = new OrderItem(this, mi, quantity, request);
        if (orderedItems.contains(oi))
            return null;
        orderedItems.add(oi);
        return oi;
    }
    public void setOrdertime(LocalDateTime ordertime) {
        this.ordertime = ordertime;
    }

    public String getStatus() {
        return status;
    }

    public int getOrderNo() {
        return orderNo;
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
    
    /**
     * A method to get the total price of the order by adding the subtotals
     * of each ordered item
     * @return total price of the order
     */
   public double getTotal()
   {
       double total = 0.0;
       for (OrderItem oi:orderedItems)
           total += oi.getTotal();
       return total;
   }
   
   /**
    * A method to remove an order item from the arraylist
    * @param unwanted the orderitem to be removed
    * @return 
    */
   public boolean removeItem(OrderItem unwanted)
   {
       return orderedItems.remove(unwanted);
   }
}
