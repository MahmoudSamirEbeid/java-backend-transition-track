import java.util.*;
import java.util.stream.*;

public class Exercise {

    public static void main(String[] args) {

        // Original list of products
        List<String> products =
                Arrays.asList("Laptop", "Pen", "Notebook", "Headphones", "Smartphone");

        // Print the original list
        System.out.println("Original List: " + products);

        // Filter, transform, sort, and collect
        List<String> filteredProducts = products.stream()
                .filter(product -> product.length() > 5)
                .map(String::toUpperCase)
                .sorted()
                .toList();

        // Print the final result
        System.out.println("Filtered Products: " + filteredProducts);
    }
}