// File: Bank.java
import java.util.*;
import java.io.*;

public class Bank implements HasMenu {

    private Admin admin = new Admin();
    private CustomerList customers = new CustomerList();

    public static void main(String[] args) {
        new Bank();
    }

    public Bank() {
        loadCustomers();          // load saved customers
        start();                  // start main menu
        saveCustomers();          // save on exit
    }

    @Override
    public String menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nBank Menu");
        System.out.println("0) Exit System");
        System.out.println("1) Login as admin");
        System.out.println("2) Login as customer");
        System.out.print("Action: ");
        return input.nextLine();
    }

    @Override
    public void start() {
        boolean keepGoing = true;
        while (keepGoing) {
            String choice = menu();
            switch (choice) {
                case "0" -> keepGoing = false;
                case "1" -> {
                    System.out.println("Admin login");
                    if (admin.login()) startAdmin();
                }
                case "2" -> loginAsCustomer();
                default -> System.out.println("Please enter 0, 1, or 2");
            }
        }
    }

    private void startAdmin() {
        boolean keepGoing = true;
        while (keepGoing) {
            String choice = admin.menu();
            switch (choice) {
                case "0" -> keepGoing = false;
                case "1" -> reportAllCustomers();
                case "2" -> addUser();
                case "3" -> applyInterest();
                default -> System.out.println("Invalid option");
            }
        }
    }

    public void loadSampleCustomers() {
        customers.add(new Customer("Alice", "1111"));
        customers.add(new Customer("Bob", "2222"));
        customers.add(new Customer("Cindy", "3333"));
    }

    private void reportAllCustomers() {
        for (Customer c : customers) {
            System.out.println(c.getReport());
        }
    }

    private void addUser() {
        Scanner input = new Scanner(System.in);
        System.out.print("User name: ");
        String userName = input.nextLine();
        System.out.print("PIN: ");
        String pin = input.nextLine();
        customers.add(new Customer(userName, pin));
    }

    private void applyInterest() {
        for (Customer c : customers) {
            c.savings.calcInterest();
        }
    }

    private void loginAsCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.print("User name: ");
        String userName = input.nextLine();
        System.out.print("PIN: ");
        String pin = input.nextLine();

        Customer currentCustomer = null;
        for (Customer c : customers) {
            if (c.login(userName, pin)) {
                currentCustomer = c;
                break;
            }
        }

        if (currentCustomer == null) {
            System.out.println("Customer not found");
        } else {
            currentCustomer.start();
        }
    }

    public void saveCustomers() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Customers.dat"))) {
            out.writeObject(customers);
        } catch (Exception e) {
            System.out.println("Error saving customers: " + e.getMessage());
        }
    }

    public void loadCustomers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Customers.dat"))) {
            customers = (CustomerList) in.readObject();
        } catch (Exception e) {
            System.out.println("No saved customer data found, starting fresh.");
            loadSampleCustomers();
        }
    }

}

// Simple wrapper for ArrayList<Customer>
class CustomerList extends ArrayList<Customer> implements Serializable {}