import java.util.Arrays;
import java.util.Comparator;

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + ", Category=" + category + "]";
    }
}

public class ProductSearch {
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String productName) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = productName.compareToIgnoreCase(products[mid].getProductName());
            if (cmp == 0) return products[mid];
            if (cmp > 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("201", "Laptop", "Electronics"),
            new Product("202", "Phone", "Electronics"),
            new Product("203", "Tablet", "Electronics")
        };
        Product result = linearSearch(products, "Phone");
        System.out.println("Linear Search Result: " + (result != null ? result : "Product not found"));
        result = binarySearch(products, "Tablet");
        System.out.println("Binary Search Result: " + (result != null ? result : "Product not found"));
    }
}
