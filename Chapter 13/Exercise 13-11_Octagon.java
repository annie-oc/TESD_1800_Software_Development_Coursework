// Author: Annie O'Connor
// Date: 9.8.26

// the Octagon class extends the GeometricObject class
/* aka Octagon inherits the color and filled properties
 * and the getter/setter methods from GeometricObject
 */
// also implements 2 interfaces (comparable and cloneable)
/* Comparable<Octagon> lets us compare 2 Octagon objects
 * using the compareTo() method
 */
/* Cloneable lets us make a copy of an Octagon object */

public class Octagon extends GeometricObject
        implements Comparable<Octagon>, Cloneable {

            // store the length of a side of the octagon
            // all sides will be equal, so only do this once
            private double side;

            // create a no-argument constructor
            /* when creating an Octagon w/o giving it a side length
             * the side is automatically 1
             */
            public Octagon() {
                side = 1;
            }

            // create a constructor that allows us to specify the side length later
            public Ocatagon(double side) {
                this.side = side;
            }

            // create getter method for side
            // allows other classes to retrieve the side length
            public double getSide() {
                return side;
            }

            // create setter method for side
            // allows other classes to change the side length
            public void setSide(double side) {
                this.side = side;
            }

            // calculate and return the area
            public double getArea() {
                return (2 + 4 / Math.sqrt(2)) * side * side;
            }

            // calculate and return the perimeter
            public double getPerimeter() {
                return 8 * side;
            }

            // compareTo() method comes from the Comparable interface
            // it compares this octagon to another
            // rn we are comparing the area of 2 octagons
            @Override
            public int compareTo(Octagon other) {

                // aka if this octagon's area is larger, return 1
                if (getArea() > other.getArea())
                    return 1;

                // aka if this octagon's area is smaller, return -1
                else if (getArea() < other.getArea())
                    return -1;

                // aka if the areas are equal, return 0
                else
                    return 0;
            }

            // clone() method lets us make a copy of an existing object
            // super.clone() calls the clone() method from the parent class
            @Override
            public Object clone() {

                // try is used b/c clone() could throw an exception
                try {
                    return super.clone();
                }

                /* if cloning isn't supported, this catches the error
                 * instead of the program crashing
                 */
                catch (CloneNotSupportedException ex) {
                    return null;
                }
            }

            // toString() method creates a String representation of the Octagon
            /* useful if we eventually want to print the entire object
             * using System.out.println()
             */
            @Override
            public String toString() {
                return "Octagon: side = " + side + 
                        " area = " + getArea();
            }
        }
