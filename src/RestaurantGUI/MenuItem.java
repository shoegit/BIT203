/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantGUI;

/**
 * A class to represent MenuItem objects
 * @author ngsm
 */
public class MenuItem {
    
    private int itemNo;
    private String description;
    private double price;
    private static int nextNo = 100;
    
    public MenuItem(String description, double price) {
        this.itemNo = nextNo++;
        this.description = description;
        this.price = price;
    }

    public int getItemNo() {
        return itemNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "itemNo=" + itemNo + ", description=" + description + ", price=" + price + '}';
    }

    public static int getNextNo() {
        return nextNo;
    }
    
    
    
    
    
}
