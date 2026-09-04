// Author: Annie O'Connor
// Date: 9.4.26


import java.util.Date;


// create a program that actually runs everything
import java.util.Scanner;


public class TestTriangle {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);


       System.out.print("Enter the length of side1: ");
       double side1 = input.nextDouble();


       System.out.print("Enter the length of side2: ");
       double side2 = input.nextDouble();


       System.out.print("Enter the length of side3: ");
       double side3 = input.nextDouble();


       System.out.print("Enter the color of your triangle: ");
       String color = input.next();


       System.out.print("Is the triangle filled? Choose true or false: ");
       boolean filled = input.nextBoolean();


       Triangle triangle = new Triangle(side1, side2, side3);


       triangle.setColor(color);
       triangle.setFilled(filled);


       System.out.println();
       System.out.println("Area: " + triangle.getArea());
       System.out.println("Perimeter: " + triangle.getPerimeter());
       System.out.println("Color: " + triangle.getColor());
       System.out.println("Filled: " + triangle.isFilled());
   }
}


// create a parent class
public abstract class GeometricObject {
   private String color = "white";
   private boolean filled;
   private java.util.Date dateCreated;


   protected GeometricObject() {
       dateCreated = new java.util.Date();
   }


   protected GeometricObject(String color, boolean filled) {
       dateCreated = new Date();
       this.color = color;
       this.filled = filled;
   }


   public String getColor() {
       return color;
   }


   public void setColor(String color) {
       this.color = color;
   }


   public boolean isFilled() {
       return filled;
   }


   public void setFilled(boolean filled) {
       this.filled = filled;
   }


   public java.util.Date getDateCreated() {
       return dateCreated;
   }


   @Override
   public String toString() {
       return "created on " + dateCreated + "\ncolor: " + color
               + " and filled: " + filled;
   }
}


// create a child class with a specific geometric object inheriting things from the parent class
public class Triangle extends GeometricObject {
   private double side1;
   private double side2;
   private double side3;


   public Triangle(double side1, double side2, double side3) {
   this.side1 = side1;
   this.side2 = side2;
   this.side3 = side3;
   }


   public double getSide1() {
   return side1;
   }


   public double getSide2() {
   return side2;
   }


   public double getSide3() {
   return side3;
   }


   public double getArea() {
   double s = (side1 + side2 + side3) / 2;


       return Math.sqrt(s * (s - side1) *
           (s - side2) * (s - side3));
   }


   public double getPerimeter() {
       return side1 + side2 + side3;
   }


   @Override
   public String toString() {
       return "Triangle: side1 = " + side1
           + " side2 = " + side2
           + " side3 = " + side3;
   }
}

