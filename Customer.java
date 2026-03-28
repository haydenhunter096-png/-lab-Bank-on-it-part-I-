import java.util.Scanner;
import java.io.Serializable;

class LegacyUser implements Serializable {
    protected String userName;
    protected String PIN;
    private transient Scanner input = new Scanner(System.in);

    public boolean login(){
        System.out.print("Enter username: ");
        String u = input.nextLine();
        System.out.print("Enter PIN: ");
        String p = input.nextLine();
        return userName != null && PIN != null && userName.equals(u) && PIN.equals(p);
    }

    public boolean login(String u, String p){
        return userName != null && PIN != null && userName.equals(u) && PIN.equals(p);
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPIN(String pin){
        this.PIN = pin;
    }

    public String getUserName(){
        return userName;
    }
}


class LegacyCheckingAccount {
    private double balance = 0.0;
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


class LegacySavingsAccount {
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


    public void calcInterest(){
        double interest = balance * 0.05;  
        balance += interest;
        System.out.println("Interest applied to savings: $" + interest);
    }
}