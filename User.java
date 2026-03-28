import java.util.*;
import java.io.*;

public abstract class User implements Serializable, HasMenu {
    protected String userName = "";
    protected String PIN = "";

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setPIN(String PIN) {
        if (PIN.matches("^\\d{4}$")) {
            this.PIN = PIN;
        } else {
            System.out.println("PIN must be 4 numeric digits.");
            System.out.println("Setting PIN to 0000");
            this.PIN = "0000";
        }
    }

    public String getPIN() {
        return this.PIN;
    }

    public boolean login(String userNameIn, String pinIn) {
        return userNameIn.equals(this.userName) && pinIn.equals(this.PIN);
    }

    protected static final Scanner input = new Scanner(System.in);

    public boolean login() {
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
    }

    public abstract String getReport();
}
