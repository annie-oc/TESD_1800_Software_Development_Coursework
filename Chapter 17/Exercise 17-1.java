// Author: Annie O'Connor
// Date: 9.15.26

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Exercise17_01 {
    public static void amain(String[] args) throws FileNotFoundException {

        // create a file object for Exercise17.01.txt
        File file = new File(Exercise17_01.text);

        // create a file writer (creates the connection to the file)
        // "true" means append, so existing data isn't erased
        FileWriter fileWriter = new FileWriter(file, true);

        // create a print writer (which writes text to the file)
        // "true" tells java to append new data instead of deleting old data
        PrintWriter output = new PrintWriter(file, true);

        // generate and write 100 random integers to the file
        for (int i = 0; i < 100; i++) {

            // generate a random integer from 0 to 99
            int number = (int)(Math.random() * 100);

            // write each number followed by a space
            output.print(number + " ");
        }

        // close the file
        output.close();
    }
}
