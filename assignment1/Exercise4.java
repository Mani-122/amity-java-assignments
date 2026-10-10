import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Are you a citizen (true/false): ");
        boolean isCitizen = sc.nextBoolean();

        if (age >= 18 && isCitizen) {
            System.out.println("Eligible to vote");
        } else if (age < 18 || !isCitizen) {
            System.out.println("Not eligible to vote");
        }
    }
}
