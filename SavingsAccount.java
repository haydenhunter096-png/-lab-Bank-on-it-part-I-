import java.util.*;

public class SavingsAccount extends CheckingAccount {
    double interestRate = .05d;

    public static void main(String[] args){
        SavingsAccount sa = new SavingsAccount();
        sa.start();
    }

    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    public double getInterestRate(){
        return this.interestRate;
    }

    
    public void start(){
        boolean running = true;
        while(running){
            System.out.println("\nSavings Menu");
            System.out.println("1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("0) Back");
            System.out.print("Choice: ");
            String choice = input.nextLine();   
                case "1": deposit(); break;
                case "2": withdraw(); break;
                case "0": running = false; break;
                default: System.out.println("Enter 0, 1, or 2");
            }
        }
    }

    public void calcInterest(){
        double interestAmount = this.balance * this.interestRate;
        this.balance += interestAmount;
        System.out.println("New balance: " + this.getBalanceString());
    }
}