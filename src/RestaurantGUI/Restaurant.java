/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantGUI;
import java.util.*;
/**
 * A Restaurant has a list of Menu items
 * @author ngsm
 */
public class Restaurant {
    
    private ArrayList<MenuItem> menuItems;
    private ArrayList<Table> tables;
    
    public Restaurant()
    {
        menuItems = new ArrayList<>();
        tables = new ArrayList<>();
        setupTables();
        
    }
    
    public void addTable(int tableNo, int seatingCapacity, int xPos, int yPos)
    {
        Table t= new Table(tableNo, seatingCapacity, xPos, yPos);
        tables.add(t);
    }
 
    /**
     * find a table based on a tableNO
     * @param tableNo
     * @return 
     */
    public Table getTable(int tableNo)
    {
        for (Table t:tables)
            if (t.getTableNo()== tableNo)
                return t;
        return null;
    }
    
    /**
     * create new order
     * @return 
     */
    public Order createNewOrder(int tableNo, int numPax)
    {
        Table theTable = getTable(tableNo);
        if (theTable == null)
        {
            return null;
        }
        return theTable.addOrderToTable(numPax);
        
    }
    
    public ArrayList<Order> allOrders()
    {
        ArrayList<Order> orderList = new ArrayList<>();
        for (Table t:tables)
        {
            orderList.addAll(t.getOrders());
        }
        return orderList;
    }
    
    public ArrayList<Table> getTables()
    {
        return tables;
    }
    
    public void setupTables()
    {
        int tableNo = 1;
        for (int y = 10; y <=250; y += 70)
        {
            for (int x = 10; x <=250; x+= 70)
            {
                int cap = (int)((Math.random()*6)+2);
                addTable(tableNo++, cap, x, y);
            }
        }
    }
    public MenuItem findMenuItem(int itemNo)
    {
        for (MenuItem mi:menuItems)
            if (mi.getItemNo()==itemNo)
                return mi;
        return null;
    }
    
    public boolean addMenuItem(String description, double price)
    {
        MenuItem mi = new MenuItem(description, price);
        return menuItems.add(mi);
    }

    public void updateItem(MenuItem theItem, String description, double price )
    {
        theItem.setDescription(description);
        theItem.setPrice(price);
    }
}
