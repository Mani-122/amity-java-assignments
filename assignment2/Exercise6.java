import java.util.Scanner;

class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Author: " + name + " (" + gender + "), Email: " + email;
    }
}

class Book {
    private String title;
    private double price;
    private Author author;

    public Book(String title, double price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        String priceStr = (price == (long) price) ? String.format("%d", (long) price) : String.valueOf(price);
        return "Book: " + title + "\nPrice: " + priceStr + "\n" + author.toString();
    }
}

public class Exercise6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] parts = line.split(",");
        String title = parts[0].trim();
        double price = Double.parseDouble(parts[1].trim());
        String authorName = parts[2].trim();
        String email = parts[3].trim();
        char gender = parts[4].trim().charAt(0);

        Author author = new Author(authorName, email, gender);
        Book book = new Book(title, price, author);

        System.out.println(book);
    }
}
