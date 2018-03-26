/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantGUI;

import javax.swing.table.AbstractTableModel;
import java.util.*;

/**
 *
 * @author ngsm
 */
public class OrderTableModel extends AbstractTableModel {

    // set up the column headers
    private static final String[] colHeader = {"Order No", "Table No", "Order Date", "Order Time", "Status"};

    // This model manages an array of order objects
    private ArrayList<Order> orders;

    // constructor to set the model to an array passed in
    public OrderTableModel(ArrayList<Order> orders) {
        setOrders(orders);
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public int getRowCount() {
        return orders.size();
    }

    @Override
    public int getColumnCount() {
        return colHeader.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Order theOrder = orders.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return new Integer(theOrder.getOrderNo());
            case 1:
                return new Integer(theOrder.getTheTable().getTableNo());
            case 2:
                return theOrder.getOrdertime().toLocalDate();
            case 3:
                return theOrder.getOrdertime().getHour() + ":" + theOrder.getOrdertime().getMinute();
            case 4:
                return theOrder.getStatus();
            default:
                return "";
        }

    }

    public String getColumnName(int column) {
        return colHeader[column];
    }

    public Order getOrderAt(int index) {
        Order theOrder = orders.get(index);
        return theOrder;
    }

}
