import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class StringAndFileOperations {

    public static void main(String[] args) {
        // Part 1: String concatenation using StringBuilder and StringBuffer
        String sampleString = "hello";
        int iterations = 1_000_000;

        // Measure time for StringBuilder
        long startBuilder = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            builder.append(sampleString);
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        // Measure time for StringBuffer
        long startBuffer = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            buffer.append(sampleString);
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        System.out.println("Time taken by StringBuilder: " + timeBuilder + " ns");
        System.out.println("Time taken by StringBuffer: " + timeBuffer + " ns");

        // Part 2: Read a large file and count words
        String filePath = "large_text_file.txt";  // Provide the path to your 100MB text file
        try {
            long wordCount = countWordsInFile(filePath);
            System.out.println("Total word count in the file: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static long countWordsInFile(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);  // Use FileReader directly
        BufferedReader br = new BufferedReader(fr);

        String line;
        long wordCount = 0;

        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }

        br.close();
        fr.close();

        return wordCount;
    }
}
