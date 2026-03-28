// -------- User class --------
import java.io.Serializable;
import java.util.Scanner;

class User implements Serializable {
    private String userName;
    private String pin;

    // login method: checks username & PIN
    public boolean login() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username: ");
        String u = input.nextLine();
        System.out.print("Enter PIN: ");
        String p = input.nextLine();
        return userName != null && pin != null && userName.equals(u) && pin.equals(p);
    }

    // login with parameters (used by Bank)
    public boolean login(String u, String p) {
        return userName != null && pin != null && userName.equals(u) && pin.equals(p);
    }

    // PIN and username getters/setters
    public void setUserName(String userName) { this.userName = userName; }
    public void setPIN(String pin) { this.pin = pin; }
    public String getUserName() { return userName; }
    public String getPIN() { return pin; }
}
// -------- Customer class --------
import java.io.Serializable;
import java.util.Scanner;

public class Customer extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    public CheckingAccount checking = new CheckingAccount();
    public SavingsAccount savings = new SavingsAccount();
    private transient Scanner input = new Scanner(System.in);

    public Customer() { this.setUserName("Alice"); this.setPIN("1111"); }
    public Customer(String userName, String PIN) { this.setUserName(userName); this.setPIN(PIN); }

    // Change PIN function
    public void changePIN() {
        System.out.print("Enter new PIN: ");
        String newPIN = input.nextLine();
        setPIN(newPIN);
        System.out.println("PIN changed successfully.");
    }

    // Simple report
    public String getReport() {
        return "User: " + getUserName() +
               ", Checking: " + checking.getBalanceString() +
               ", Savings: " + savings.getBalanceString();
    }

    // Customer menu
    public void start() {
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.println("\nCustomer Menu");
            System.out.println("0) Exit");
            System.out.println("1) Manage Checking");
            System.out.println("2) Manage Savings");
            System.out.println("3) Change PIN");
            System.out.print("Action: ");
            String choice = input.nextLine();
            switch (choice) {
                case "0" -> keepGoing = false;
                case "1" -> checking.start();
                case "2" -> savings.start();
                case "3" -> changePIN();
                default -> System.out.println("Enter 0-3 only.");
            }
        }
    }
}