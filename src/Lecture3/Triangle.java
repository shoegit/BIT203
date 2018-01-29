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
public class Triangle extends Shape{
    private double base;
    private double height;

    public Triangle(String name, double base, double height) {
        super(name);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
    
    @Override
   public String getName()
   {
       return "Triangle " + super.getName();
   }
    
    public String toString()
    {
        return getName() + " with base " + base + " height "+ height;
    }
    
    
}
