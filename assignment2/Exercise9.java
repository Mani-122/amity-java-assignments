import java.util.Scanner;

class Course {
    private String courseName;
    private String duration;

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDuration() {
        return duration;
    }
}

class Student {
    protected String name;
    protected Course enrolledCourse;

    public Student(String name, Course enrolledCourse) {
        this.name = name;
        this.enrolledCourse = enrolledCourse;
    }

    @Override
    public String toString() {
        return "Student: " + name + " Course: " + enrolledCourse.getCourseName() + " (" + enrolledCourse.getDuration() + ")";
    }
}

class PremiumStudent extends Student {
    private int discount;

    public PremiumStudent(String name, Course enrolledCourse, int discount) {
        super(name, enrolledCourse);
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Premium Student: " + name + " Course: " + enrolledCourse.getCourseName() + " (" + enrolledCourse.getDuration() + ") Discount: " + discount + "%";
    }
}

public class Exercise9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] courseParts = sc.nextLine().split(",");
        Course course = new Course(courseParts[0].trim(), courseParts[1].trim());

        String[] studentParts = sc.nextLine().split(",");
        Student s1 = new Student(studentParts[0].trim(), course);

        String[] premiumParts = sc.nextLine().split(",");
        PremiumStudent s2 = new PremiumStudent(premiumParts[0].trim(), course, Integer.parseInt(premiumParts[2].trim()));

        System.out.println(s1);
        System.out.println(s2);
    }
}
