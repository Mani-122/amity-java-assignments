import java.util.HashSet;
import java.util.Scanner;

class Attendance {
    private HashSet<String> students;

    public Attendance() {
        students = new HashSet<>();
    }

    public void markAttendance(String name) {
        if (students.contains(name)) {
            System.out.println(name + " is already marked present");
        } else {
            students.add(name);
            System.out.println("Attendance marked for " + name);
        }
    }

    public void displayAttendance() {
        System.out.println("Present Students: " + students);
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Attendance attendance = new Attendance();

        System.out.println("Enter names to mark attendance (type 'exit' to finish):");
        while (true) {
            System.out.print("Enter name to mark attendance: ");
            String name = sc.nextLine().trim();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            if (!name.isEmpty()) {
                attendance.markAttendance(name);
            }
        }

        attendance.displayAttendance();
    }
}
