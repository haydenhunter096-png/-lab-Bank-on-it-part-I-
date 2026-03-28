// File: Admin.java
import java.util.Scanner;
import java.io.Serializable;

public class Admin extends User implements HasMenu, Serializable {

    // Constructor: default admin credentials
    public Admin() {
        userName = "admin";  // directly set for simplicity
        PIN = "0000";
    }

    // Display admin menu and get user choice
    public String menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nAdmin Menu");
        System.out.println("0) Exit this menu");
        System.out.println("1) Full customer report");
        System.out.println("2) Add user");
        System.out.println("3) Apply interest to savings accounts");
        System.out.print("Action: ");

        return input.nextLine();
    }

    // Start is empty — handled in Bank
    public void start() {
    }

    // Simple report of admin info
    public String getReport() {
        return "Admin userName: " + userName + ", Admin PIN: " + PIN;
    }
}