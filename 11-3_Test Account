// Author: Annie O'Connor
// Date: 9.1.26

import java.util.Date;

    import java.util.Scanner;

    public class TestAccount {

        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);

            System.out.print("Enter your account number: ");
            int accountNumber = input.nextInt();

            System.out.print("Enter 1 for checking, 2 for savings.");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("Enter the overdraft limit: $");
                double overdraftLimit = input.nextDouble();

                Checking checking = new Checking(accountNumber, overdraftLimit);

                System.out.println();
                System.out.println("Checking Account:");
                System.out.println(checking);

                System.out.prinln();
                System.out.print("Press 1 to deposit, 2 to withdraw: ");
                int transaction = input.nextIny();

                if (transaction == 1) {
                    System.out.print("How much would you like to deposit?: $");
                    double deposit = input.nextDouble();

                    checking.depost(deposit);
                }
                else if (transaction == 2) {
                    System.out.print("How much would you like to withdraw?: $");
                    double withdraw = input.nextDouble();

                    checking.withdraw(withdraw);
                }
                else {
                    System.out.println("Invalid choice.");
                }

                System.out.println();
                System.out.println("Updated Checking Account:");
                System.out.println(checking);
            }
            else if (choice == 2) {

                Savings savings = new Savings(accountNumber);

                System.out.println();
                System.out.println("Savings Account:");
                System.out.println(savings);

                System.out.println();
                System.out.println("Press 1 to deposit, 2 to withdraw.");
                int transaction = input.nextInt();

                if (transaction == 1) {
                    System.out.print("How much would you like to deposit?: $");
                    double deposit = input.nextDouble();

                    savings.deposit(deposit);
                }
                else if (transaction == 2) {
                    System.out.print("How much would you like to withdraw?: $");
                    double withdraw = input.nextDouble();

                    savings.withdraw(withdraw);
                }
                else {
                    System.out.println("Invalid choice.");
                }

                System.out.println();
                System.out.println("Updated Savings Account:");
                System.out.println(savings);
            }
            else {
                System.out.println("Invalid choice.");
            }

            input.close();
        }
    }
    class Account {

        private int accountNumber;
        private double balance;
        private double annualInterestRate;
        private Date dateCreated;
    
        public Account(int accountNumber) {
            this.accountNumber = accountNumber;
            this.balance = 0.0;
            this.annualInterestRate = 0.0;
            this.dateCreated = new Date();
        }
    
            public int getAccountNumber() {
                return accountNumber;
            }
    
            public double getBalance() {
                return balance;
            }
    
            public double getAnnualInterestRate() {
                return annualInterestRate;
            }
    
            public Date getDateCreated() {
                return dateCreated;
            }
    
            public void deposit(double amount) {
                balance += amount;
            }
    
            public void withdraw(double amount) {
                if (amount <= balance) {
                    balance -= amount;
                }
                else {
                    System.out.println("Insufficient funds.");
                }
            }
    
            @Override
            public String toString() {
                return "Account Number: " + accountNumber
                        + "\nBalance: $" + balance
                        + "\nAnnual Interest Rate: " + annualInterestRate
                        + "\nDate Created: " + dateCreated;
            }
        }
    
        class Checking extends Account {
    
            private double overdraftLimit;
    
            public Checking(int accountNumber, double overdraftLimit) {
                super(accountNumber);
                this.overdraftLimit = overdraftLimit;
            }
    
            public double overdraftLimit() {
                return overdraftLimit;
            }
    
            @Override
            public String toString() {
                return "Checking Account"
                        + "\nAccount Number: " + getAccountNumber()
                        + "\nBalance: $" + getBalance()
                        + "\nAnnual Interest Rate: " + getAnnualInterestRate()
                        + "\nDate Created: " + getDateCreated()
                        + "\nOverdraft Limit: $" + overdraftLimit;
            }
        }
        
        class Savings extends Account {
    
            public Savings(int accountNumber) {
                super(accountNumber);
            }
    
            @Override
            public String toString() {
                return "Savings Account"
                        + "\nAccount Number: " + getAccountNumber()
                        + "\nBalance: $" + getBalance()
                        + "\nAnnual Interest Rate: " + getAnnualInterestRate()
                        + "\nDate Created: " + getDateCreated();
            }
        }
    
