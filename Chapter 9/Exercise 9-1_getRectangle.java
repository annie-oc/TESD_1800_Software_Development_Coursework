public class getRectangle {


    public static void main(String[] args) {
 
 
        Rectangle rectangle1 = new Rectangle();
        System.out.println("The area of the rectangle with the height of " + rectangle1.height +
            " and the width of " + rectangle1.width + " is " + rectangle1.getArea() +
            " and the perimeter is " + rectangle1.getPerimeter() + ".");
 
 
        Rectangle rectangle2 = new Rectangle(35.9, 3.5);
        System.out.println("The area of the rectangle with the height of " + rectangle2.height +
            " and the width of " + rectangle2.width + " is " + rectangle2.getArea() +
            " and the perimeter is " + rectangle2.getPerimeter() + ".");
 
 
    }
 }
 
 
 class Rectangle {
    double height;
    double width;
 
 
    //create rectangle1 with a height of 40 and a width of 4
    Rectangle() {
        height = 40;
        width = 4;
    }
 
 
    //create rectangle2 with a height of 35.9 and a width of 3.5
    Rectangle(double newHeight, double newWidth) {
        height = newHeight;
        width = newWidth;
    }
 
 
    //return the area of both rectangles
    double getArea() {
        return height * width;
    }
 
 
    //return the perimeter of both rectangles
    double getPerimeter() {
        return (height * 2) + (width * 2);
    }
 }
 
 
