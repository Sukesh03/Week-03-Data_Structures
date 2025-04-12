import java.io.*;

public class FileReaderInputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        String filePath = "sample.txt";
        generateSmallFile(filePath);

        long frTime = readUsingFileReader(filePath);
        System.out.println("FileReader Time: " + frTime + "ms");

        long isrTime = readUsingInputStreamReader(filePath);
        System.out.println("InputStreamReader Time: " + isrTime + "ms");
    }

    public static void generateSmallFile(String filePath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        String line = "This is a small line for testing file reading.\n";
        for (int i = 0; i < 10000; i++) {
            writer.write(line);
        }
        writer.close();
    }

    public static long readUsingFileReader(String filePath) throws IOException {
        long start = System.currentTimeMillis();
        FileReader reader = new FileReader(filePath);
        BufferedReader br = new BufferedReader(reader);
        while (br.readLine() != null) {}
        br.close();
        return System.currentTimeMillis() - start;
    }

    public static long readUsingInputStreamReader(String filePath) throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        while (br.readLine() != null) {}
        br.close();
        return System.currentTimeMillis() - start;
    }
}
