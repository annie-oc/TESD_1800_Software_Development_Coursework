public class TestOctagon {
    public static void main(String[] args) {

        // create the first octagon
        Octagon octagon1 = new Octagon(5);
        // clone the first octagon
        Octagon octagon2 = (Octagon) octagon1.clone();

        // display the info for the first octagon
        System.out.println("Octagon 1: ");
        System.out.println("Side: " + octagon1.getSide());
        System.out.println("Area: " + octagon1.getArea());
        System.out.println("Perimeter: " + octagon1.getPerimeter());

        // display the info for the coned octagon
        System.out.println("\nOctagon 2: ");
        System.out.println("Side: " + octagon2.getSide());
        System.out.println("Area: " + octagon2.getArea());
        System.out.println("Perimeter: " + octagon2.getPerimeter());

        // compare the two
        System.out.println("\nCompareison result: " + 
                octagon1.compareTo(octagon2));
    }
}
