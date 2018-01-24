/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial1;

/**
 * A class to represent Window objects
 *
 * @author ngsm
 */
public class Window {

    private String direction;

    public Window(String direction) {
        if (direction.isEmpty()) {
            this.direction = "unknown";
        } else {
            this.direction = direction;
        }
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        if (!direction.isEmpty()) {
            this.direction = direction;
        }
    }

    public String toString()
    {
        return "window facing " + direction;
    }
}
