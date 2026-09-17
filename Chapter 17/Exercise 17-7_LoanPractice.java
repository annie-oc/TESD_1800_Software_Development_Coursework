// Author: Annie O'Connor
// Date: 9.17.26

import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException {
        // create the objects
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);

        // write the objects to the file
        try (
            ObjectOutputStream output = 
            new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        }
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }

        // call the method to read and print the data
        try {
            outputData(loan1, loan2);
        }
        catch (EOFException ex) {
            System.out.println("Error reading the file");
        }
    }

    public static void outputData(Loan loan1, Loan loan2) throws EOFException {
        try (
            ObjectInputStream input =
            new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
        ) {
            // read the objects and cast them back to the loan class
            input.readObject(loan1);
            input.readObject(loan2);

            // print the successfully read objects
            System.out.println("Loan One: " + loan1);
            System.out.println("Loan Two: " + loan2);

        }
        catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        catch (EOFException ex) {
            System.out.println("End of file");
        }
        catch (IOException ex) {
            System.out.println("File read error");
        }
    }
}
