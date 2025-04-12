public class FibonacciComparison {
    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};

        for (int n : testValues) {
            System.out.println("N = " + n);

            if (n <= 30) {
                long startRecursive = System.currentTimeMillis();
                int resultRecursive = fibonacciRecursive(n);
                long endRecursive = System.currentTimeMillis();
                System.out.println("Recursive Result: " + resultRecursive + " | Time: " + (endRecursive - startRecursive) + "ms");
            } else {
                System.out.println("Recursive Result: Skipped (Too Slow)");
            }

            long startIterative = System.currentTimeMillis();
            int resultIterative = fibonacciIterative(n);
            long endIterative = System.currentTimeMillis();
            System.out.println("Iterative Result: " + resultIterative + " | Time: " + (endIterative - startIterative) + "ms");

            System.out.println();
        }
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
