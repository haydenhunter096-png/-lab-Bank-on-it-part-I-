
import java.util.Scanner;
import java.io.Serializable;

public class Admin extends User implements HasMenu, Serializable {

   
    public Admin() {
        userName = "admin";  
        PIN = "0000";
    }

    
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

    
    public void start() {
    }

    
    public String getReport() {
        return "Admin userName: " + userName + ", Admin PIN: " + PIN;
    }
}