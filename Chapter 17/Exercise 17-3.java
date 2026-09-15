// Author: Annie O'Connor
// Date: 9.15.26

import java.io.DataInputStream;
// reads primitive data types from a file

import java.io.DataOutputStream;
// writes primitive data types to a file

import java.io.EOFException;
// EOF = end of file
// tells java there's nothing left to read

import java.io.File;
// lets the program represent a file or folder

import java.io.FileInputStream;
// opens a file for reading

import java.io.FileOutputStream;
// opens a file for writing

import java.io.IOException;
// in case something goes wrong

public class Exercise17_03 {
    public static void main(String[] args) throws IOException {

        // call the method that writes 100 random integers
        writeIntegers();

        // call the method that reads the integers and finds the sum
        System.out.println("The sum of the integers is: " + sumIntegers());
    }

    /* this method creates the file if it doesn't exist
     * and appends 100 random integers if it does exist
    */
    public static void writeIntegers() throws IOException {

        // create a file object
        File file = new File("Exercise17_03.dat");

        // create a data output stream
        /* "true" means "append new data if the file
         * already exists, don't delete old data" */
        DataOutputStream output = 
            new DataOutputStream(
                new FileOutputStream(file, true)
            );

        // write 100 random integers to the file
        for (int i = 0; i< 100; i++) {

            // generate a random integers from 0 to 99
            int number = (int)(Math.random() * 100);

            // write the integer to the file
            output.writeInt(number);
        }

        // close the output stream
        output.close();
    }

    /* this method reads all the integers from the
     * file and returns their sum
     */
    public static long sumIntegers() throws IOException {

        // create a data input stream to read the file
        DataInputStream input =
            new DataInputStream(
                new FileInputStream("Exercise17_03.dat")
            );

        // create a variable to keep track of the sum
        long sum = 0;

        try {

            /* tell the program to keep reading integers
             * until the end of the file
             */
            while (true) {

                // read one integer from the file
                int number = input.readInt();

                // add the integer to the sum
                sume += number;
            }
        } catch (EOFException ex) {

            //EOFException means we reached the end of the file
        }

        // clsoe the input stream
        input.close();

        // return the total sum
        return sum;
    }
}
