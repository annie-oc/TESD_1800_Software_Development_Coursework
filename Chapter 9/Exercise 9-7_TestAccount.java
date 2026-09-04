//Author: Annie O'Connor
//Date: 8.27.26


import java.util.Date;


public class TestAccount {


   public static void main(String[] args) {


       //create Account object with ID 1122
       //with beginning balance of $20,000
       Account account = new Account(1122, 20000);


       //set annual interest rate
       account.setAnnualInterestRate(4.5);


       //withdraw $2,500
       account.withdraw(2500);


       //deposit $3,000
       account.deposit(3000);


       //display account info
       System.out.println("Account ID: " + account.getId());
       System.out.println("Balance: $" + account.getBalance());
       System.out.println("Monthly Interest Rate: " + account.getMonthlyInterestRate() + "%");
       System.out.println("Monthly Interest: $" + account.getMonthlyInterest());
       System.out.println("Date Created: " + account.getDateCreated());
   }
}


//create the Account object class
class Account {


   //date fields
   private int ID = 0;
   private double balance = 0;
   private double annualInterestRate = 0;
   private Date dateCreated;


   //no-arg constructor
   public Account() {
       dateCreated = newDate();
   }


   //constructor with specified ID and initial balance
   public Account(int id, double balance) {
       this.id = id;
       this.balance = balance;
       dateCreated = new Date();
   }


   //accessor for ID
   public int getId() {
       return id;
   }


   //mutator for ID
   public void setId(int id) {
       this.id = id;
   }


   //accessor for balance
   public double getBalance() {
       return balance;
   }


   //mutator for balance
   public void setBalance(double balance) {
       this.balance = balance;
   }


   //accessor for annual interest rate
   public double getAnnualInterestRate() {
       return annualInterestRate;
   }


   //mutator for annual interest rate
   public void setAnnualInterestRate(double annualInterestRate) {
       this.annualInterestRate = annualInterestRate;
   }


   //accessor for date created
   public Date getDateCreated() {
       return dateCreated;
   }


   //return monthly interest rate
   public double getMonthlyInterestRate() {
       return annualInterestRate / 12;
   }


   //return monthly interest
   public double getMonthlyInterest() {
       return balance * (getMonthlyInterestRate() / 100);
   }


   //withdraw specified amount
   public void withdraw(double amount) {
       balance -= amount;
   }


   //deposit specified amount
   public void deposit(double amount) {
       balance += amount;
   }
}

