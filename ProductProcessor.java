import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (Rs." + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 75000),
            new Product("Smartphone", "Electronics", 50000),
            new Product("Headphones", "Electronics", 3000),
            new Product("Refrigerator", "Appliances", 40000),
            new Product("Microwave", "Appliances", 10000),
            new Product("Jeans", "Clothing", 2000),
            new Product("T-Shirt", "Clothing", 800),
            new Product("Jacket", "Clothing", 5000)
        );

        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, prodList) -> 
            System.out.println(category + ": " + prodList)
        );

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                p -> p.category,
                Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
            ));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println(category + ": " + product.orElse(null))
        );

        double averagePrice = products.stream()
            .mapToDouble(p -> p.price)
            .average()
            .orElse(0.0);

        System.out.println("\nAverage price of all products: Rs." + averagePrice);
    }
}
