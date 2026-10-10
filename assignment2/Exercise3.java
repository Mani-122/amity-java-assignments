import java.util.Scanner;

class Employee {
    protected String name;
    protected String id;
    protected double basicSalary;

    public Employee() {
    }

    public Employee(String name, String id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    @Override
    public String toString() {
        return "Employee " + name + " (" + id + ") Salary: " + calculateSalary();
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, String id, double basicSalary, double bonus) {
        super(name, id, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    public String toString() {
        return "Manager " + name + " (" + id + ") Salary: " + calculateSalary();
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] parts = line.split(",");
            String type = parts[0].trim();
            String name = parts[1].trim();
            String id = parts[2].trim();
            double basicSalary = Double.parseDouble(parts[3].trim());

            if (type.equalsIgnoreCase("Manager")) {
                double bonus = Double.parseDouble(parts[4].trim());
                Manager m = new Manager(name, id, basicSalary, bonus);
                System.out.println(m);
            } else {
                Employee e = new Employee(name, id, basicSalary);
                System.out.println(e);
            }
        }
    }
}
