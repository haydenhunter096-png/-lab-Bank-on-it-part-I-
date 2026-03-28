import java.util.Scanner;

public class CheckingAccount {
    protected double balance = 0.0;                   
    protected Scanner input = new Scanner(System.in); 

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