import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankDirectory {
    private HashMap<Integer, String> accounts;

    public BankDirectory() {
        accounts = new HashMap<>();
    }

    public void addAccount(int accNo, String name) {
        accounts.put(accNo, name);
        System.out.println("Account added successfully.");
        System.out.println("Account No: " + accNo + " -> " + name);
    }

    public void getCustomer(int accNo) {
        if (accounts.containsKey(accNo)) {
            System.out.println("Customer Name: " + accounts.get(accNo));
        } else {
            System.out.println("Account not found.");
        }
    }

    public void displayAll() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("All Accounts:");
            for (Map.Entry<Integer, String> entry : accounts.entrySet()) {
                System.out.println("Account No: " + entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankDirectory directory = new BankDirectory();

        while (true) {
            System.out.println("\n1. Add Account");
            System.out.println("2. Get Customer Name");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Account No: ");
                int accNo = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine().trim();
                directory.addAccount(accNo, name);
            } else if (choice == 2) {
                System.out.print("Enter Account No: ");
                int accNo = sc.nextInt();
                directory.getCustomer(accNo);
            } else if (choice == 3) {
                directory.displayAll();
            } else if (choice == 4) {
                System.out.println("Exiting.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
