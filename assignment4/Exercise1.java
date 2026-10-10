import java.util.ArrayList;
import java.util.Scanner;

class Library {
    private ArrayList<String> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String title) {
        books.add(title);
        System.out.println("Book added successfully.");
    }

    public void removeBook(String title) {
        if (books.remove(title)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found in library.");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Current Books:");
            for (String b : books) {
                System.out.println(b);
            }
        }
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter book title: ");
                String title = sc.nextLine().trim();
                lib.addBook(title);
                lib.displayBooks();
            } else if (choice == 2) {
                System.out.print("Enter book title to remove: ");
                String title = sc.nextLine().trim();
                lib.removeBook(title);
            } else if (choice == 3) {
                lib.displayBooks();
            } else if (choice == 4) {
                System.out.println("Exiting.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
