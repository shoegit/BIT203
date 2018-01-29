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
import java.util.*;

public class TestShapes {
    public static void main(String[] args)
    {
        Shape [] shapes = new Shape[5];
        Scanner sc = new Scanner(System.in);
        
        for (int i= 0; i < 5; i++)
        {
            System.out.println("Do you want (c)ircle or (t)riangle?");
            String type = sc.nextLine();
            System.out.print("Enter the name of the shape :");
            String name = sc.nextLine();
            if (type.equals("c"))
            {
             System.out.print("Enter the radius of the circle:");
             double radius = sc.nextDouble();
             sc.nextLine();
                Circle c = new Circle(name, radius);
                shapes[i] = c;
            }
            else
            {
             System.out.print("Enter the base of the triangle:");
             double base = sc.nextDouble();
             sc.nextLine();
                    System.out.print("Enter the height of the triangle:");
             double height = sc.nextDouble();
             sc.nextLine();
             Triangle t = new Triangle(name, base, height);
              shapes[i] = t;
            }
        }
        
        double totalArea = 0.0;
        for (int i = 0; i < shapes.length; i++)
        {
            totalArea += shapes[i].getArea();
        }
        System.out.println("The total area of all shapes is "+ totalArea);
    }
}
