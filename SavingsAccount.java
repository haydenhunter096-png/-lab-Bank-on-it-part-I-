import java.util.*;

public class SavingsAccount extends CheckingAccount {
  double interestRate = .05d;

  public static void main(String[] args){
    SavingsAccount sa = new SavingsAccount();
    sa.start();
  } // end main

  public void setInterestRate(double interestRate){
    this.interestRate = interestRate;
  } // end setInterestRate

  public double getInterestRate(){
    return this.interestRate
  } // end getInterestRate

  public void calcInterest(){
    // note applied by admin, not customer
    double interestAmount = this.balance * this.interestRate;
    this.balance += interestAmount;
    System.out.println("New balance: " + this.getBalanceString());
  } // end calcInterest

} // end class def