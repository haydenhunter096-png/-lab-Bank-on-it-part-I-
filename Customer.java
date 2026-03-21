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
            if (result.equals("0")){
                keepGoing = false;
            } else if (result.equals("1")){
                System.out.println("Checking account: ");
                this.checking.start();
            } else if (result.equals("2")){
                System.out.println("Savings account:");
                this.savings.start();
            } else if (result.equals("3")){
                changePin();
            } else {
                System.out.println("You should enter 0, 1, 2, and 3");
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


class User implements Serializable {
    private String userName;
    private String pin;
    private transient Scanner input = new Scanner(System.in);

    public boolean login() {
        System.out.print("Enter username: ");
        String enteredUser = input.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = input.nextLine();

        return userName != null && pin != null &&
               userName.equals(enteredUser) &&
               pin.equals(enteredPin);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPIN(String pin) {
        this.pin = pin;
    }

    public String getUserName() {
        return userName;
    }
}


class CheckingAccount {
    private double balance = 1000.0;

    public void start() {
        System.out.println("Checking balance: " + getBalanceString());
    }

    public String getBalanceString() {
        return "$" + balance;
    }
}

class SavingsAccount {
    private double balance = 5000.0;

    public void start() {
        System.out.println("Savings balance: " + getBalanceString());
    }

    public String getBalanceString() {
        return "$" + balance;
    }
}