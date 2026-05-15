package stage3_core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Collections Demo ===");

        // 1. List - ordered, allows duplicates (like std::vector)
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple");  // duplicate allowed
        System.out.println("List: " + fruits);
        System.out.println("Element at index 1: " + fruits.get(1));
        System.out.println("Size: " + fruits.size());

        // 2. Set - no duplicates (like std::set, but unordered)
        Set<Integer> numbers = new HashSet<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(1);  // duplicate, will be ignored
        numbers.add(3);  // duplicate, will be ignored
        System.out.println("\nSet (no duplicates): " + numbers);

        // 3. Map - key-value pairs (like std::map, but unordered)
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 87);
        scores.put("Charlie", 92);
        System.out.println("\nMap: " + scores);
        System.out.println("Bob's score: " + scores.get("Bob"));

        // 4. Iterating over collections
        System.out.println("\n--- Iteration ---");
        System.out.print("For-each over List: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }

        System.out.print("\nFor-each over Map entries: ");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
        }

        System.out.println("\n\n=== Demo Complete ===");
    }
}
