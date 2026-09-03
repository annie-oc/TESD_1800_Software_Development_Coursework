// Author: Annie O'Connor
// Date: 9.3.26

import java.util.Scanner;

public class ArrayIndexExample {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

       // create array with 100 index spots
       int[] numbers = new int[100];

       // fill it with random numbers 0-99
       // 100 is out of bounds
       for (int i = 0; i < numbers.length; i++) {
           numbers[i] = (int)(Math.random() * 100);
       }

       // the user chooses a random index
       System.out.print("Enter an index (0-99) to get a random number: ");
       int index = input.nextInt();

       // the program will then tell the user the int located at that index
       try {
           System.out.println("The number is " + numbers[index]);
       }
       // if the user enters an invalid index, Java catches it with this exception
       catch (ArrayIndexOutOfBoundsException e) {
           System.out.println("That index does not exist.");
       }
   }
}

