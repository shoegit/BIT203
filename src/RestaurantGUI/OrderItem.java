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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    public void setStatus(String status) {
        this.status = status;
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
    
    public MenuItem getMenuItem()
    {
        return theMenuItem;
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
