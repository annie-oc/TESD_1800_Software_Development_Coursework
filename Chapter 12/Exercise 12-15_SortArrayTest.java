// Author: Annie O'Connor
// Date: 9.3.26

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays; // needed to use Arrays.sort()

public class Exercise12_15 {
   public static void main(String[] args) throws IOException {

       // create a file (if it doesn't already exist)
       File file = new File("Exercise12_15.txt");

       // write 100 random integers between 0 and 99 to the file
       PrintWriter output = new PrintWriter(file);

       for (int i = 0; i < 100; i++) {
           int number = (int)(Math.random() * 100);
           // use print() instead of println()
           // b/c assignment says the numbers should be all on one line
           // with spaces between them
           output.print(number + " ");
       }

       output.close();

       // read the numbers from the file
       Scanner input = new Scanner(file);

       // create an array that stores those numbers
       // b/c we need somewhere to stores the numbers after we read them from the file
       int[] numbers = new int[100];

       for (int i = 0; i < 100; i++) {
           numbers[i] = input.nextInt();
       }

       input.close();

       // sort those numbers
       Arrays.sort(numbers);

       // display the numbers from smallest to largest
       for (int i = 0; i < numbers.length; i++) {
           System.out.print(numbers[i] + " ");
       }
   }
}
