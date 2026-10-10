import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String productName;
    private int price;
    private int quantity;

    public Product() {
    }

    public Product(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return productName + " x" + quantity + " = " + getTotalPrice();
    }
}

class Order {
    private String orderId;
    private List<Product> products;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public int calculateTotal() {
        int total = 0;
        for (Product p : products) {
            total += p.getTotalPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Products:\n");
        for (Product p : products) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("Total: ").append(calculateTotal());
        return sb.toString();
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String orderId = sc.nextLine().trim();
        int n = Integer.parseInt(sc.nextLine().trim());

        Order order = new Order(orderId);
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(",");
            String name = parts[0].trim();
            int price = Integer.parseInt(parts[1].trim());
            int qty = Integer.parseInt(parts[2].trim());
            order.addProduct(new Product(name, price, qty));
        }

        System.out.println(order);
    }
}
