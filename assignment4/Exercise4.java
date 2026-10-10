import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class Inventory {
    private HashMap<Integer, Integer> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(int id, int stock) {
        products.put(id, stock);
        System.out.println("Product " + id + " added with stock " + stock);
    }

    public void updateStock(int id, int newStock) {
        if (products.containsKey(id)) {
            products.put(id, newStock);
            System.out.println("Product " + id + " stock updated to " + newStock);
        } else {
            System.out.println("Product " + id + " not found.");
        }
    }

    public void displayInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("Current Inventory:");
        // Using Iterator for traversal
        Iterator<Map.Entry<Integer, Integer>> iterator = products.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println("Product ID: " + entry.getKey() + " | Stock: " + entry.getValue());
        }
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();
                System.out.print("Enter Stock: ");
                int stock = sc.nextInt();
                inventory.addProduct(id, stock);
            } else if (choice == 2) {
                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();
                System.out.print("Enter New Stock: ");
                int newStock = sc.nextInt();
                inventory.updateStock(id, newStock);
            } else if (choice == 3) {
                inventory.displayInventory();
            } else if (choice == 4) {
                System.out.println("Exiting.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
