public class ControlFlow {
    public static void main(String[] args) {
        System.out.println("=== Java Control Flow ===\n");

        int score = 85;

        System.out.println("--- if-else ---");
        if (score >= 90) {
            System.out.println("Excellent");
        } else if (score >= 60) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        System.out.println("\n--- switch ---");
        int day = 3;
        switch (day) {
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            default: System.out.println("Other day");
        }

        System.out.println("\n--- for loop ---");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\n--- while loop ---");
        int count = 0;
        while (count < 3) {
            System.out.println("count = " + count);
            count++;
        }

        System.out.println("\n--- do-while ---");
        int n = 0;
        do {
            System.out.println("Executed once");
            n++;
        } while (n < 2);

        System.out.println("\n=== C++ Comparison ===");
        System.out.println("C++ and Java control flow syntax are almost identical!");
    }
}