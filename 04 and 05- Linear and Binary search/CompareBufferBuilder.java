public class CompareBufferBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        // Using StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            builder.append(text);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        // Using StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            buffer.append(text);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        System.out.println("Time taken by StringBuilder: " + timeBuilder + " ns");
        System.out.println("Time taken by StringBuffer: " + timeBuffer + " ns");
    }
}
