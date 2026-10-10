import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name) {
        this.name = name;
    }

    public void registerStudent(int age) throws InvalidAgeException {
        if (age <= 17) {
            throw new InvalidAgeException("Age must be above 17 for registration");
        }
        this.age = age;
        System.out.println("Student " + name + " registered successfully with age " + age);
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        Student student = new Student(name);

        try {
            student.registerStudent(age);
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
