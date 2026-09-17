// Author: Annie O'Connor
// Date: 9.17.26

import java.io.*;
import java.util.Scanner;

public class EncryptFiles {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an input file name: ");
        String inputFileName = input.nextLine();

        System.out.print("Enter an output file name: ");
        String outputFileName = input.nextLine();

        try (
            FileInputStream fis = new FileInputStream(inputFileName);
            FileOutputStream fos = new FileOutputStream(outputFileName);
        ) {
            int originalByte;

            while ((originalByte = fis.read()) != -1) {
                int encryptedByte = (originalByte + 5) & 0xFF;

                fos.write(encryptedByte);
            }

            System.out.println("File successfully encrypted.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading or writing files.");
        }
    }
}
