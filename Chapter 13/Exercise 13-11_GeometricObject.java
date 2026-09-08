//Author: Annie O'Connor
// Date: 9.8.26

// this is the parent class
// the other classes will inherit its properties and methods

public class GeometricObject {

    // let's store the color of this object
    // making it private so no other class can access it
    private String color = "white";
    // let's store if the object is filled or not
    private boolean filled;

    // create a no-argument constructor
    // use this when creating an object w/o providing any info for it
    public GeometricObject() {
    }

    // create a constructor to specify the object's color and if it's filled
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // create getter method for the color
    // we originally made this a private variable
    // the getter method allows other classes to retieve the value of a private variable
    public String getColor() {
        return color;
    }

    // create setter method for the color
    // the setter method allows other classes to alter the value of a private variable
    public void setColor(String color) {
        this.color = color;
    }

    // create getter method for filled
    // now the object is filled
    public boolean isFilled() {
        return filled;
    }

    // create setter method for filled
    // allows another class to change if the object is filled or not
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
