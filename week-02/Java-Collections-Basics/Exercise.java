import java.util.*;

public class Exercise {

    public static void main(String[] args) {

        // Original list of names
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "David", "Bob");

        // Print the original list
        System.out.println("Original List: " + names);

        // Remove duplicates while preserving insertion order
        Set<String> uniqueNames = new LinkedHashSet<>(names);

        // Print the unique names
        System.out.println("Unique Names: " + uniqueNames);
    }
}