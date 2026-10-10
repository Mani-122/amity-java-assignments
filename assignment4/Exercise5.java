import java.util.LinkedHashSet;
import java.util.Scanner;

class CourseEnrollment {
    private LinkedHashSet<String> students;

    public CourseEnrollment() {
        students = new LinkedHashSet<>();
    }

    public void enrollStudent(String name) {
        if (students.contains(name)) {
            System.out.println(name + " is already enrolled");
        } else {
            students.add(name);
            System.out.println("Enrolled: " + name);
        }
    }

    public void displayEnrolledStudents() {
        System.out.println("Enrolled Students: " + students);
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseEnrollment enrollment = new CourseEnrollment();

        System.out.println("Enter names to enroll (type 'exit' to finish):");
        while (true) {
            System.out.print("Enroll: ");
            String name = sc.nextLine().trim();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            if (!name.isEmpty()) {
                enrollment.enrollStudent(name);
            }
        }

        enrollment.displayEnrolledStudents();
    }
}
