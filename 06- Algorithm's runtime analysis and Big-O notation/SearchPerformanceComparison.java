import java.util.Arrays;

public class SearchPerformanceComparison {
    public static void main(String[] args) {
        int[] linearArray1K = generateArray(1000);
        int[] binaryArray1K = Arrays.copyOf(linearArray1K, linearArray1K.length);

        int[] linearArray10K = generateArray(10000);
        int[] binaryArray10K = Arrays.copyOf(linearArray10K, linearArray10K.length);

        int[] linearArray1M = generateArray(1000000);
        int[] binaryArray1M = Arrays.copyOf(linearArray1M, linearArray1M.length);

        // Comparing Linear Search
        System.out.println("Linear Search Performance:");
        compareLinearSearch(linearArray1K, linearArray10K, linearArray1M);

        // Comparing Binary Search
        System.out.println("\nBinary Search Performance:");
        compareBinarySearch(binaryArray1K, binaryArray10K, binaryArray1M);
    }

    public static int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1; // Fill array with consecutive integers
        }
        return arr;
    }

    public static void compareLinearSearch(int[] arr1K, int[] arr10K, int[] arr1M) {
        long startTime = System.nanoTime();
        linearSearch(arr1K, arr1K.length);
        long endTime = System.nanoTime();
        System.out.println("1,000 elements: " + (endTime - startTime) / 1000000.0 + " ms");

        startTime = System.nanoTime();
        linearSearch(arr10K, arr10K.length);
        endTime = System.nanoTime();
        System.out.println("10,000 elements: " + (endTime - startTime) / 1000000.0 + " ms");

        startTime = System.nanoTime();
        linearSearch(arr1M, arr1M.length);
        endTime = System.nanoTime();
        System.out.println("1,000,000 elements: " + (endTime - startTime) / 1000000.0 + " s");
    }

    public static void compareBinarySearch(int[] arr1K, int[] arr10K, int[] arr1M) {
        long startTime = System.nanoTime();
        binarySearch(arr1K, arr1K.length, 500); // Searching for value in the middle
        long endTime = System.nanoTime();
        System.out.println("1,000 elements: " + (endTime - startTime) / 1000000.0 + " ms");

        startTime = System.nanoTime();
        binarySearch(arr10K, arr10K.length, 5000);
        endTime = System.nanoTime();
        System.out.println("10,000 elements: " + (endTime - startTime) / 1000000.0 + " ms");

        startTime = System.nanoTime();
        binarySearch(arr1M, arr1M.length, 500000);
        endTime = System.nanoTime();
        System.out.println("1,000,000 elements: " + (endTime - startTime) / 1000000.0 + " ms");
    }

    // Linear Search Method
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // If not found
    }

    // Binary Search Method
    public static int binarySearch(int[] arr, int n, int target) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // If not found
    }
}
