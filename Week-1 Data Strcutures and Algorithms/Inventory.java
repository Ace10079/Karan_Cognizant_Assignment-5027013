import java.util.HashMap;
import java.util.Map;
class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + 
               ", Quantity=" + quantity + ", Price=" + price + "]";
    }
}
public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
        }
    }

    public void deleteProduct(String productId) {
        products.remove(productId);
    }

    public void displayProducts() {
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Product p1 = new Product("101", "Laptop", 10, 1000.0);
        Product p2 = new Product("102", "Phone", 50, 500.0);
        inventory.addProduct(p1);
        inventory.addProduct(p2);

        inventory.displayProducts();

        inventory.updateProduct("101", 8, 950.0);
        inventory.deleteProduct("102");

        inventory.displayProducts();
    }
}
