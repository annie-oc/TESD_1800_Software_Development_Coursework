import jav.util.Scanner;


public class Triangle {


   public static void main(String[] args) {


       Scanner input = new Scanner(System.in);


       System.out.print("Enter length for side one: ");
       double side1 = input.nextDouble();


       System.out.print("Enter length for side two: ");
       double side2 = input.nextDouble();


       System.out.print("Enter length for side three: ");
       double side3 = input.nextDouble();


       System.out.print("Enter a color for your triangle: ");
       String color = inputnextString();


       System.out.print("Is the triangle filled in?: ");
       boolean filled = input.nextBoolean();


       Triangle triangle = new Triangle(side1, side2, side3);


       triangle.setColor(color);
       triangle.setFilled(filled);


       System.out.println("Area: " + triangle.getArea());
       System.out.println("Perimeter: " + triangle.getPerimeter());
       System.out.println("Color: " + triangle.getColor());
       System.out.println("Filled: " + triangle.isFilled());


       input.close();
   }
}

