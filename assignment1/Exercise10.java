import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] marks = new double[5];
        double total = 0;

        System.out.println("Enter marks of 5 subjects:");
        for (int i = 0; i < 5; i++) {
            marks[i] = sc.nextDouble();
            total = total + marks[i];
        }

        double avg = total / 5;
        System.out.println("Average Marks: " + avg);

        if (avg >= 90) {
            System.out.println("Grade: A");
        } else if (avg >= 75) {
            System.out.println("Grade: B");
        } else if (avg >= 50) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: Fail");
        }
    }
}
