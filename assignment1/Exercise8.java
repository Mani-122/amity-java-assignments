import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[5];

        System.out.println("Enter marks of 5 students:");
        for (int i = 0; i < 5; i++) {
            marks[i] = sc.nextInt();
        }

        System.out.println("Marks of students:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Student " + (i + 1) + ": " + marks[i]);
        }
    }
}
