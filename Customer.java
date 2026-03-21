// File: Customer.java
import java.util.*;
import java.io.*;

public class Customer extends User implements Serializable {
    static final long serialVersionUID = 1L;

    private CheckingAccount checking = new CheckingAccount();
    private SavingsAccount savings = new SavingsAccount();
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        Customer c = new Customer();
        if (c.login()){
            c.start();
        }
    }

    public void changePin(){
        System.out.print("Enter new PIN: ");
        String newPIN = input.nextLine();
        this.setPIN(newPIN);
        System.out.println("PIN changed.");
    }

    public Customer(){
        this.setUserName("Alice");
        this.setPIN("1111");
    }

    public Customer(String userName, String PIN){
        this.setUserName(userName);
        this.setPIN(PIN);
    }

    public String getReport(){
        String report = "User: " + this.getUserName();
        report += ", Checking: " + this.checking.getBalanceString();
        report += ", Savings: " + this.savings.getBalanceString();
        return report;
    }

    public void start(){
        boolean keepGoing = true;
        String result;
        while (keepGoing){
            result = menu();
            switch(result){
                case "0":
                    keepGoing = false;
                    break;
                case "1":
                    System.out.println("Checking account: ");
                    this.checking.start();
                    break;
                case "2":
                    System.out.println("Savings account: ");
                    this.savings.start();
                    break;
                case "3":
                    changePin();
                    break;
                default:
                    System.out.println("You should enter 0, 1, 2, or 3");
            }
        }
    }

    public String menu(){
        System.out.println();
        System.out.println("Customer menu");
        System.out.println();
        System.out.println("0) Exit");
        System.out.println("1) Manage Checking");
        System.out.println("2) Manage Savings");
        System.out.println("3) Change PIN");
        System.out.println();
        System.out.print("Your action: (0-3) ");
        return input.nextLine();
    }
}

// -------- User class --------
class User implements Serializable {
    private String userName;
    private String pin;
    private transient Scanner input = new Scanner(System.in);

    public boolean login(){
        System.out.print("Enter username: ");
        String u = input.nextLine();
        System.out.print("Enter PIN: ");
        String p = input.nextLine();
        return userName != null && pin != null && userName.equals(u) && pin.equals(p);
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPIN(String pin){
        this.pin = pin;
    }

    public String getUserName(){
        return userName;
    }
}

// -------- CheckingAccount --------
class CheckingAccount {
    private double balance = 1000.0;
    private Scanner input = new Scanner(System.in);

    public void start(){
        boolean running = true;
        while(running){
            System.out.println("\nChecking Menu");
            System.out.println("1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("0) Back");
            System.out.print("Choice: ");
            String choice = input.nextLine();
            switch(choice){
                case "1": deposit(); break;
                case "2": withdraw(); break;
                case "0": running = false; break;
                default: System.out.println("Enter 0, 1, or 2");
            }
        }
    }

    public void deposit(){
        System.out.print("Amount to deposit: ");
        double amt = Double.parseDouble(input.nextLine());
        balance += amt;
        System.out.println("New balance: " + getBalanceString());
    }

    public void withdraw(){
        System.out.print("Amount to withdraw: ");
        double amt = Double.parseDouble(input.nextLine());
        if(amt > balance){
            System.out.println("Insufficient funds!");
        } else {
            balance -= amt;
            System.out.println("New balance: " + getBalanceString());
        }
    }

    public String getBalanceString(){
        return "$" + balance;
    }
}

// -------- SavingsAccount --------
class SavingsAccount {
    private double balance = 5000.0;
    private Scanner input = new Scanner(System.in);

    public void start(){
        boolean running = true;
        while(running){
            System.out.println("\nSavings Menu");
            System.out.println("1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("0) Back");
            System.out.print("Choice: ");
            String choice = input.nextLine();
            switch(choice){
                case "1": deposit(); break;
                case "2": withdraw(); break;
                case "0": running = false; break;
                default: System.out.println("Enter 0, 1, or 2");
            }
        }
    }

    public void deposit(){
        System.out.print("Amount to deposit: ");
        double amt = Double.parseDouble(input.nextLine());
        balance += amt;
        System.out.println("New balance: " + getBalanceString());
    }

    public void withdraw(){
        System.out.print("Amount to withdraw: ");
        double amt = Double.parseDouble(input.nextLine());
        if(amt > balance){
            System.out.println("Insufficient funds!");
        } else {
            balance -= amt;
            System.out.println("New balance: " + getBalanceString());
        }
    }

    public String getBalanceString(){
        return "$" + balance;
    }
}