package stage3_core;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Exception Demo ===");

        // 1. ArithmeticException (unchecked, runtime)
        int result = safeDivide(10, 0);
        System.out.println("Result: " + result);

        // 2. ArrayIndexOutOfBoundsException
        safeArrayAccess();

        // 3. Custom exception with throw
        try {
            validateAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // 4. finally always runs
        try {
            System.out.println("Entering try block...");
            int[] arr = new int[2];
            System.out.println(arr[5]);
        } finally {
            System.out.println("finally block always executes.");
        }

        System.out.println("=== Demo Complete ===");
    }

    static int safeDivide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero, returning 0.");
            return 0;
        }
    }

    static void safeArrayAccess() {
        try {
            int[] nums = {1, 2, 3};
            System.out.println("Accessing index 5: " + nums[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        }
    }

    static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative: " + age);
        }
        System.out.println("Age " + age + " is valid.");
    }
}
