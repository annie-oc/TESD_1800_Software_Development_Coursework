//Author: Annie O'Connor
//Date: 8.28.26

import java.util.Date;
import java.util.Scanner;

public class TestAccount {
  public static void main(String[] args) {

   Scanner input = new Scanner(System.in);

   Account[] accounts = new Account[10];

   for (int i = 0; i < accounts.length; i++) {
       accounts[i] = new Account(i, 100);
   }

   while (true) {

       System.out.println("Enter your ID: ");
       int id = input.nextInt();

       while (id < 0 || id > 9) {
           System.out.print("Please enter a valid ID: ");
           id = input.nextInt();
       }

       int choice;

       do {
           System.out.println("Press 1 to view current balance.");
           System.out.println("Press 2 to withdraw.");
           System.out.println("Press 3 to deposit.");
           System.out.println("Press 4 to exit.");

           choice = input.nextInt();

           if (choice == 1) {
               System.out.println("The balance is $" + accounts[id].getBalance() + ".");
           }

           else if (choice == 2) {
               System.out.println("Enter an amount to withdraw: ");
               double amount = input.nextDouble();

               accounts[id].withdraw(amount);
           }

           else if (choice == 3) {
               System.out.println("Enter an amount to deposit: ");
               double amount = input.nextDouble();

               accounts[id].deposit(amount);
           }

           else if (choice == 4) {
               System.out.println("Exiting menu.");
           }

           else {
               System.out.println("Invalid choice.");
           }

           while (choice > 4 && choice <= 0);
           }
       }
   }
}

class Account {

  private int ID = 0;
  private double balance = 0;
  private double annualInterestRate = 0;
  private Date dateCreated;

  public Account[10] {
      dateCreated = newDate();
  }

  public Account(int id, double balance) {
      this.id = id;
      this.balance = balance;
      dateCreated = new Date();
  }

  public int getId() {
      return id;
  }

  public void setId(int id) {
      this.id = id;
  }

  public double getBalance() {
      return balance;
  }

  public void setBalance(double balance) {
      this.balance = balance;
  }

  public double getAnnualInterestRate() {
      return annualInterestRate;
  }

  public void setAnnualInterestRate(double annualInterestRate) {
      this.annualInterestRate = annualInterestRate;
  }

  public Date getDateCreated() {
      return dateCreated;
  }

  public double getMonthlyInterestRate() {
      return annualInterestRate / 12;
  }

  public double getMonthlyInterest() {
      return balance * (getMonthlyInterestRate() / 100);
  }

  public void withdraw(double amount) {
      balance -= amount;
  }

  public void deposit(double amount) {
      balance += amount;
  }
}