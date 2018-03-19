/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantGUI;

import java.util.Objects;

/**
 * Order Item class - An OrderItem is recorded for an Order.
 * The ordered item is a MenuItem
 * @author ngsm
 */
public class OrderItem {
   
    private Order theOrder;
    private MenuItem theMenuItem;
    private int quantity;
    private String specialRequest;
    private String status;

    public OrderItem(Order theOrder, MenuItem theMenuItem, int quantity, String specialRequest) {
        this.theOrder = theOrder;
        this.theMenuItem = theMenuItem;
        this.quantity = quantity;
        this.specialRequest = specialRequest;
        this.status = "outstanding";
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final OrderItem other = (OrderItem) obj;
        if (!Objects.equals(this.theOrder, other.theOrder)) {
            return false;
        }
        if (!Objects.equals(this.theMenuItem, other.theMenuItem)) {
            return false;
        }
        return true;
    }
    
    public double getTotal()
    {
        return theMenuItem.getPrice() * quantity;
    }
    
    public String toString()
    {
        return "Item : " + theMenuItem.getItemNo() + " " + theMenuItem.getDescription() + " Quantity Required :" + quantity 
                + "Special Req: " + specialRequest + " Total price " + getTotal();
    }
    
}
