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
    
    public Restaurant()
    {
        menuItems = new ArrayList<>();
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
