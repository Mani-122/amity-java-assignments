import java.util.Scanner;

class Vehicle {
    protected String regNo;
    protected String brand;
    protected double baseRate;

    public Vehicle(String regNo, String brand, double baseRate) {
        this.regNo = regNo;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    public double calculateRent() {
        return baseRate;
    }
}

class Car extends Vehicle {
    public Car(String regNo, String brand, double baseRate) {
        super(regNo, brand, baseRate);
    }

    @Override
    public double calculateRent() {
        return baseRate * 1.5;
    }

    @Override
    public String toString() {
        return "Car " + regNo + " " + brand + " Rent: " + calculateRent();
    }
}

class Bike extends Vehicle {
    public Bike(String regNo, String brand, double baseRate) {
        super(regNo, brand, baseRate);
    }

    @Override
    public double calculateRent() {
        return baseRate * 1.2;
    }

    @Override
    public String toString() {
        return "Bike " + regNo + " " + brand + " Rent: " + calculateRent();
    }
}

public class Exercise12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] parts = line.split(",");
            String type = parts[0].trim();
            String regNo = parts[1].trim();
            String brand = parts[2].trim();
            double baseRate = Double.parseDouble(parts[3].trim());

            if (type.equalsIgnoreCase("Car")) {
                Car car = new Car(regNo, brand, baseRate);
                System.out.println(car);
            } else {
                Bike bike = new Bike(regNo, brand, baseRate);
                System.out.println(bike);
            }
        }
    }
}
