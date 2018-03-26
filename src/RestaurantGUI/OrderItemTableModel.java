/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantGUI;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ngsm
 */
public class OrderItemTableModel extends AbstractTableModel{

    private static final String[] colHeader =  {"Menu Item", "Quantity", "Special Request", "Status"};
    private ArrayList<OrderItem> orderItems;
    
    public OrderItemTableModel()
    {
        setOrderItems(new ArrayList<OrderItem>());
    }
    
    public void setOrderItems(ArrayList<OrderItem> orderItems)
    {
        this.orderItems = orderItems;
    }
    
    public int getRowCount() {
        return orderItems.size();
    }

    @Override
    public int getColumnCount() {
           return colHeader.length;
    }

    public String getColumnName(int column)
    {
        return colHeader[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        
        OrderItem theOrderItem = orderItems.get(rowIndex);
        MenuItem mi = theOrderItem.getMenuItem();
        switch(colIndex)
        {
            case 0:return mi.getItemNo()+" " + mi.getDescription();
            case 1: return new Integer(theOrderItem.getQuantity());
            case 2: return theOrderItem.getSpecialRequest();
            case 3: return theOrderItem.getStatus();
            default: return "";
        }
    }
    
    public OrderItem getOrderAt(int index)
    {
        OrderItem theOrderItem = orderItems.get(index);
        return theOrderItem;
    }
    
   
}
