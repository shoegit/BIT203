/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecture3;

/**
 *
 * @author ngsm
 */
public class Circle extends Shape{
    private double radius;

    public Circle(String name, double radius)
    {
        super(name);
        this.radius = radius;
        
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
}
