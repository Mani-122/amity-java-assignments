import java.util.Scanner;

abstract class Loan {
    protected double principal;
    protected double rate;
    protected double time;

    public Loan(double principal, double rate, double time) {
        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    public abstract double calculateInterest();
}

class HomeLoan extends Loan {
    public HomeLoan(double principal, double time) {
        super(principal, 8.0, time);
    }

    @Override
    public double calculateInterest() {
        return (principal * rate * time) / 100.0;
    }
}

class CarLoan extends Loan {
    public CarLoan(double principal, double time) {
        super(principal, 10.0, time);
    }

    @Override
    public double calculateInterest() {
        return (principal * rate * time) / 100.0;
    }
}

public class Exercise8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] parts = line.split(",");
            String type = parts[0].trim();
            double principal = Double.parseDouble(parts[1].trim());
            double time = Double.parseDouble(parts[2].trim());

            if (type.equalsIgnoreCase("Home")) {
                HomeLoan hl = new HomeLoan(principal, time);
                System.out.println("Home Loan Interest: " + hl.calculateInterest());
            } else {
                CarLoan cl = new CarLoan(principal, time);
                System.out.println("Car Loan Interest: " + cl.calculateInterest());
            }
        }
    }
}
