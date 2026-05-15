package stage3_core;

import java.util.ArrayList;

public class GenericDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Generics Demo ===");

        // 1. Generic class with two types
        Box<String, Integer> box = new Box<>("Score", 95);
        System.out.println(box);

        // 2. Generic method
        Integer[] numbers = {3, 1, 4, 1, 5};
        String[] words = {"apple", "banana", "cherry"};
        System.out.println("First number: " + getFirst(numbers));
        System.out.println("First word: " + getFirst(words));

        // 3. Bounded type parameter (<T extends Number>)
        System.out.println("Sum of ints: " + sumOfList(numbers));

        // 4. Without generics (unsafe, requires cast)
        ArrayList rawList = new ArrayList();
        rawList.add("hello");
        rawList.add(123);
        String s = (String) rawList.get(0);  // cast needed, unsafe

        // 5. With generics (type-safe, no cast)
        ArrayList<String> safeList = new ArrayList<>();
        safeList.add("hello");
        // safeList.add(123);  // compile error!
        String s2 = safeList.get(0);  // no cast needed

        System.out.println("=== Demo Complete ===");
    }

    // Generic class
    static class Box<K, V> {
        private K key;
        private V value;

        public Box(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Box{" + key + " = " + value + "}";
        }
    }

    // Generic method
    static <T> T getFirst(T[] array) {
        return array.length > 0 ? array[0] : null;
    }

    // Bounded type parameter: T must be Number or its subclass
    static <T extends Number> double sumOfList(T[] list) {
        double sum = 0;
        for (T item : list) {
            sum += item.doubleValue();
        }
        return sum;
    }
}
