import java.util.*;
import java.io.*;

public abstract class User implements Serializeable, HasMenu {
  String userName = "";
  String PIN = "";

  public void SetUser(String userName){
    this.userName = userName;
  } // end SetUser

  public String getUserName(){
    return this.userName;
  } // end getUser

  public void setPIN(String PIN){
    if (PIN.matches("^\\d{4}$")){
        this.PIN = PIN;
    } else {
      System.out.prinln("PIN must be 4 numeric digits..")
      System.out.prinln("Setting PIN to 0000")
      this.PIN = "0000";
    } // end if
    }
    this.PIN = PIN;
  } // end setPIN

  public String getPIN(){
    return this.PIN;
  } // end getPIN

  public boolean login(String userName, String pinIn){
    boolean result = false;
    if (userNameIn. equals(this.userName)){
      if (pinIn.equals(this.PIN)){
        result = true;
      } // end pin if
    } // end user if
    return result;
  } // end login

  public boolean login(){
    Scanner input = new Scanner(System.in);
    boolean result = false;
    System.out.print("User name: ");
    String userNameIn = input.nextLine();
    if (userNameIn.equals(this.userName)){
      System.out.print("PIN: ");
      String pinIn = input.nextLine();

      if (pinIn.equals(this.pin)){
        System.out.println("login successful");
        result = true;
      } else {
        System.out.println("Incorrect PIN");
    } else {
      System.out.println("Incorrect User Name");
    } // end if
    return result;
    } // end login 

    public abstract String getReport();

  } // end class def
}