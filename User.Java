import java.util.*;
import java.io.*;

public abstract class User implements Serializable, HasMenu {
    protected String userName = "";
    protected String PIN = "";

    public void setUserName(String userName) {
        this.userName = userName;
    } // end setUserName

    public String getUserName() {
        return this.userName;
    } // end getUserName

    public void setPIN(String PIN) {
        if (PIN.matches("^\\d{4}$")) {
            this.PIN = PIN;
        } else {
            System.out.println("PIN must be 4 numeric digits.");
            System.out.println("Setting PIN to 0000");
            this.PIN = "0000";
        }
    } // end setPIN

    public String getPIN() {
        return this.PIN;
    } // end getPIN

    public boolean login(String userNameIn, String pinIn) {
        return userNameIn.equals(this.userName) && pinIn.equals(this.PIN);
    } // end login

    public boolean login() {
        Scanner input = new Scanner(System.in);

        System.out.print("User name: ");
        String userNameIn = input.nextLine();

        System.out.print("PIN: ");
        String pinIn = input.nextLine();

        boolean result = login(userNameIn, pinIn);

        if (result) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }

        return result;
    } // end login

    public abstract String getReport();
} // end class