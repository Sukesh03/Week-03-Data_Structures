public class StringConcatBenchmark {
    public static void main(String[] args) {
        testConcatPerformance(1_000);
        testConcatPerformance(10_000);
        testConcatPerformance(1_000_000);
    }

    public static void testConcatPerformance(int n) {
        String text = "hello";
        System.out.println("\n--- Operations: " + n + " ---");

        if (n <= 10_000) {
            long startString = System.currentTimeMillis();
            String str = "";
            for (int i = 0; i < n; i++) {
                str += text;
            }
            long endString = System.currentTimeMillis();
            System.out.println("String time: " + (endString - startString) + "ms");
        } else {
            System.out.println("Skipping String concatenation for large n = " + n);
        }

        long startBuilder = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(text);
        }
        long endBuilder = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endBuilder - startBuilder) + "ms");

        long startBuffer = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append(text);
        }
        long endBuffer = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (endBuffer - startBuffer) + "ms");
    }
}
