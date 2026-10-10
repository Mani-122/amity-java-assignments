import java.util.Scanner;

class BankTransaction extends Thread {
    private String description;
    private double amount;

    public BankTransaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void run() {
        System.out.println(description);
    }
}

public class Exercise10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Transaction1: ₹");
        double t1Amount = sc.nextDouble();

        System.out.print("Transaction2: ₹");
        double t2Amount = sc.nextDouble();

        BankTransaction t1;
        BankTransaction t2;

        if (t1Amount > t2Amount) {
            t1 = new BankTransaction("High-value transaction processed first", t1Amount);
            t2 = new BankTransaction("Low-value transaction processed later", t2Amount);
            t1.setPriority(Thread.MAX_PRIORITY);
            t2.setPriority(Thread.MIN_PRIORITY);
        } else {
            t1 = new BankTransaction("Low-value transaction processed later", t1Amount);
            t2 = new BankTransaction("High-value transaction processed first", t2Amount);
            t1.setPriority(Thread.MIN_PRIORITY);
            t2.setPriority(Thread.MAX_PRIORITY);
        }

        // High priority thread executes first
        if (t1.getPriority() > t2.getPriority()) {
            t1.start();
            try {
                t1.join();
            } catch (InterruptedException e) {
            }
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException e) {
            }
        } else {
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException e) {
            }
            t1.start();
            try {
                t1.join();
            } catch (InterruptedException e) {
            }
        }
    }
}
