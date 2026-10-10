import java.util.Scanner;

class UniversityLogin {
    public void login(String username) {
        if (username == null) {
            throw new NullPointerException("Username cannot be null");
        }
        System.out.println("Login successful for: " + username);
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();

        if (username.equalsIgnoreCase("null") || username.isEmpty()) {
            username = null;
        }

        UniversityLogin ul = new UniversityLogin();

        try {
            ul.login(username);
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
