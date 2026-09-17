// Author: Annie O'Connor
// Date: 9.17.26

import java.io.*;
import java.util.Scanner;

public class DecryptFiles {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the encrypted input file name: ");
        String inputFileName = input.nextLine();

        System.out.print("Enter the decrypted output file name: ");
        String outputFileName = input.nextLine();

        try (
            FileInputStream fis = new FileInputStream(inputFileName);
            FileOutputStream fos = new FileOutputStream(outputFileName);
        ) {
            int encryptedByte;

            while ((encryptedByte = fis.read()) != -1) {

                int decryptedByte = (encryptedByte - 5) & 0xFF;

                fos.write(decryptedByte);
            }

            System.out.println("File successfully decrypted.");

        } catch (FileNotFoundException e) {
            System.out.println("Could not find the specified file.");
        } catch (IOException e) {
            System.out.println("Error reading or writing the files.");
        }
    }
}
