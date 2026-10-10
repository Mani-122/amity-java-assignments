import java.util.Scanner;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }
}

class Doctor extends Person {
    protected String specialization;

    public Doctor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpecialization: " + specialization;
    }
}

class Surgeon extends Doctor {
    private String surgeryType;

    public Surgeon(String name, int age, String specialization, String surgeryType) {
        super(name, age, specialization);
        this.surgeryType = surgeryType;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSurgery Type: " + surgeryType;
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] parts = line.split(",");
        String name = parts[0].trim();
        int age = Integer.parseInt(parts[1].trim());
        String specialization = parts[2].trim();
        String surgeryType = parts[3].trim();

        Surgeon surgeon = new Surgeon(name, age, specialization, surgeryType);
        System.out.println(surgeon);
    }
}
