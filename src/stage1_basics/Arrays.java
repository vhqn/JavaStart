public class Arrays {
    public static void main(String[] args) {
        System.out.println("=== Java Arrays ===\n");

        int[] numbers = {5, 3, 8, 1, 9};
        System.out.println("Array length: " + numbers.length);
        System.out.println("First element: " + numbers[0]);
        System.out.println("Last element: " + numbers[numbers.length - 1]);

        System.out.println("\n--- Iterate with for ---");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        System.out.println("\n--- for-each loop ---");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("\n--- 2D Array ---");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n=== C++ Comparison ===");
        System.out.println("C++: int arr[5] = {5,3,8,1,9};");
        System.out.println("Java: int[] arr = {5,3,8,1,9};");
        System.out.println("Java arrays have .length property, C++ uses sizeof()");
    }
}