import java.util.*;
import java.io.*;

public class Bank implements HasMenu {

    Admin admin = new Admin();
    CustomerList customers = new CustomerList();

    public static void main(String[] args){
        new Bank();
    } // end main

    public Bank(){
        //this.loadSampleCustomers();
        //this.saveCustomers();
        this.loadCustomers();
        this.start();
        this.saveCustomers();
    } // end constructor

    public String menu(){
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Bank Menu");
        System.out.println();
        System.out.println("0) Exit System");
        System.out.println("1) Login as admin");
        System.out.println("2) Login as customer");
        System.out.println();
        System.out.println("Action: ");
        String response = input.nextLine();
        return response;
    } // end menu

    public void start(){
        boolean keepGoing = true;
        while (keepGoing){
            String response = menu();
            if (response.equals("0")){
              keepGoing = false;
            } else if (response.equals("1")){
              System.out.println("Admin login");
              if (this.admin.login()){
                startAdmin();
              } // end if
            } else if (response.equals("2")){
              System.out.println("Customer login"); 
              this.LoginAsCustomer(); 
            } else{
              System.out.println("Please eneter 0, 1, or 2");  
            } // end if 
        } // end while

    } // end start

    public void startAdmin(){
      boolean keepGoing = true;
      while (keepGoing){
        String response = admin.menu();
        if (response.equals("0")){
          keepGoing = false;
        } else if (response.equals("1")){
          System.out.println("Full customer report");
          this.reportAllCustomers();
        } else if (response.equals("2")){
          System.out.println("Add a user");
          this.addUser();  
        } else if (response.equals("3")){
          System.out.println("Apply interest to savings"); 
          this.applyInterest(); 
        } // end if
      } // end while

    } // end startAdmin
    
    public void loadSampleCustomers(){
      customers.add(new Customer("Alice", "1111"));
      customers.add(new Customer("Bob", "2222"));
      customers.add(new Customer("Cindy", "3333"));
    } // end loadSampleCustomers

    public void reportAllCustomers(){
        for (Customer customer: customers){
          System.out.println(customer.getReport());
        } // end for
    } // end reportAllCustomers

    public void addUser(){
      Scanner input = new Scanner(System.in);
      System.out.print("User name: ");
      String userName = input.nextLine();
      System.out.print("PIN: ");
      String PIN = input.nextLine();
      customers.add(new Customer(userName, PIN));
    } // end addUser

    public void applyInterest(){
      for (Customer customer: customers){
        customer.savings.calcInterest();
      } // end for  
    } // end applyInterest

    public void LoginAsCustomer(){
      Scanner input = new Scanner(System.in);
      System.out.print("User name: ");
      String userName = input.nextLine();
      System.out.print("PIN: ");
      String PIN = inpput.nextLine();

      Customer currentCustomer = null;
      for (Customer customer: customers){
        if (customer.login(userNameIn, PINin)){
          currentCustomer = customer;  
        } // end if
      } // end for
    
    
    if (currentCustomer == null){
      System.out.println("Customer not found");
    } else {
      currentCustomer.start();  
    } // end if
  }  // end loginAsCustomer

  public void saveCustomers(){
    try {
      FileOutputStream fo = new FileOutputStream("Customers.dat");
      ObjectOutputStream abOut = new ObjectOutputStream(fo);
      abOut.writeObject(customers);
      abOut.close();
      fo.close();
    } catch (Exception e){
      System.out.println(e.getMessage());
    } // end try
  } // end saveCustomers


  public void loadCustomers(){
    try {
      FileOutputStream fi = new FileInputStream("Customers.dat");
      ObjectInputStream obIn = new ObjectInputStream(fi);
      customers = (CustomersList)obIn.readObject();
      obIn.close();
      fi.close();
    } catch (Exception e){
      System.out.println(e.getMessage());
    } // end try
  } // end loadCustomers

} // end Bank

class CustomerList extends ArrayList<Customer> {};