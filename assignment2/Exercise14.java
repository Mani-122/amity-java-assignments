import java.util.Scanner;

class Account {
    private String accNo;
    private String holderName;
    private double balance;

    public Account() {
        this.balance = 0.0;
    }

    public Account(String accNo, String holderName, double initialBalance) {
        this.accNo = accNo;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Exercise14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account();

        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");
            String command = parts[0];

            if (command.equalsIgnoreCase("deposit")) {
                double amount = Double.parseDouble(parts[1]);
                acc.deposit(amount);
            } else if (command.equalsIgnoreCase("withdraw")) {
                double amount = Double.parseDouble(parts[1]);
                acc.withdraw(amount);
            } else if (command.equalsIgnoreCase("getBalance")) {
                System.out.println("Balance: " + acc.getBalance());
            }
        }
    }
}
