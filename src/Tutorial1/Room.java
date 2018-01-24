/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial1;

/**
 * A class to represent Room objects
 * A Room has ONE dimension object and MANY Window objects
 * @author ngsm
 */
public class Room {
    private String name;
    private int noOfChairs;
    private boolean isBooked;
    private Dimension roomDimension;
    private Window[] roomWindows;
    private int numWindows;

    public Room(String name, int noOfChairs, boolean isBooked, Dimension roomDimension) {
        this.name = name;
        this.noOfChairs = noOfChairs;
        this.isBooked = isBooked;
        this.roomDimension = roomDimension;
        this.roomWindows = new Window[5];
        this.numWindows = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfChairs() {
        return noOfChairs;
    }

    public void setNoOfChairs(int noOfChairs) {
        this.noOfChairs = noOfChairs;
    }

    public boolean isIsBooked() {
        return isBooked;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public Dimension getRoomDimension() {
        return roomDimension;
    }

    public void setRoomDimension(Dimension roomDimension) {
        this.roomDimension = roomDimension;
    }
    
    public String toString()
    {
        String roomInfo = "Room " + name + " with dimension ";
        roomInfo += roomDimension.toString() + "(in m) with windows ";
        for (int i = 0; i < numWindows; i++)
            roomInfo += roomWindows[i].toString() + ",";
        roomInfo += " and " + noOfChairs + " chairs ";
        roomInfo += " and is already booked : " + isBooked;
        return roomInfo;
    }
    
    public Window addWindow(String direction)
    {
        if (roomWindows.length == numWindows)
            return null;
        Window newWindow = new Window(direction);
        roomWindows[numWindows++] = newWindow;
        return newWindow;
        
    }
    
    public static void main(String[] args)
    {
        // Create a Dimension object with the 
        // width and length set as 5 m and 4 m respectively
        Dimension d = new Dimension(5, 4);
        // Create a tutorial room named “TR1” with 5 m wide and 4 m in height. 
        //There are 15 chairs in the room. No department has booked the room.
        Room tuteRoom = new Room("TR1", 15, false, d);
        // Add two windows to the Room, 
        //one faces “East” and one faces “South”
        tuteRoom.addWindow("East");
        tuteRoom.addWindow("South");
        // Display the detail of these objects either using toString method or the getter methods.
        System.out.println(tuteRoom.toString());
    }
    
}
