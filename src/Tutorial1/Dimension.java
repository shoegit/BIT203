/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial1;

/**
 * A class to represent the dimension of a room Dimension comprises width and
 * length
 *
 * @author ngsm
 */
public class Dimension {

    private int width;
    private int length;

    /**
     * Constructor that creates a dimension
     * if parameters are invalid set default to 100
     * @param inWidth
     * @param inLength 
     */
    public Dimension(int inWidth, int inLength) {
        if (inWidth > 0) {
            width = inWidth;
        } else {
            width = 100;
        }
          if (inLength > 0) {
            length = inLength;
        } else {
            length = 100;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width > 0)
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length > 0 )
        this.length = length;
    }
    
    public String toString()
    {
        return width + " x " + length;
    }
}
