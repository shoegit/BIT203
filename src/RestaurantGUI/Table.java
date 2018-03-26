/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantGUI;

import java.util.*;

/**
 *
 * @author ngsm
 */
public class Table {

    private int tableNo;
    private int seatingCapacity;
    private String currentStatus;
    private int xPos;
    private int yPos;
    private ArrayList<Order> tableOrders;

    public Table(int tableNo, int seatingCapacity, int xPos, int yPos) {
        this.tableNo = tableNo;
        this.seatingCapacity = seatingCapacity;
        this.xPos = xPos;
        this.yPos = yPos;
        this.currentStatus = "Available";
        tableOrders = new ArrayList<>();

    }
    
    // get the orders from that table
    public ArrayList<Order> getOrders()
    {
        return tableOrders;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public String toString() {
        return tableNo + " seats " + seatingCapacity + " status : " + currentStatus;
    }
    
    public Order addOrderToTable(int numPax)
    {
        Order newOrder = new Order(this, numPax);
        tableOrders.add(newOrder);
        setCurrentStatus("Occupied");
        return newOrder;
    }
}
