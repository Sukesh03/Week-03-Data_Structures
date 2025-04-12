import java.util.Arrays;

public class SortingPerformanceComparison {
    public static void main(String[] args) {
        int[] bubbleArray1K = generateArray(1000);
        int[] mergeArray1K = Arrays.copyOf(bubbleArray1K, bubbleArray1K.length);
        int[] quickArray1K = Arrays.copyOf(bubbleArray1K, bubbleArray1K.length);

        int[] bubbleArray10K = generateArray(10000);
        int[] mergeArray10K = Arrays.copyOf(bubbleArray10K, bubbleArray10K.length);
        int[] quickArray10K = Arrays.copyOf(bubbleArray10K, bubbleArray10K.length);

        int[] bubbleArray1M = generateArray(1000000);
        int[] mergeArray1M = Arrays.copyOf(bubbleArray1M, bubbleArray1M.length);
        int[] quickArray1M = Arrays.copyOf(bubbleArray1M, bubbleArray1M.length);

        System.out.println("Bubble Sort Performance:");
        compareBubbleSort(bubbleArray1K, bubbleArray10K, bubbleArray1M);

        System.out.println("\nMerge Sort Performance:");
        compareMergeSort(mergeArray1K, mergeArray10K, mergeArray1M);

        System.out.println("\nQuick Sort Performance:");
        compareQuickSort(quickArray1K, quickArray10K, quickArray1M);
    }

    public static int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        return arr;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void compareBubbleSort(int[] arr1K, int[] arr10K, int[] arr1M) {
        long startTime = System.nanoTime();
        bubbleSort(arr1K);
        long endTime = System.nanoTime();
        System.out.println("1,000 elements: " + (endTime - startTime) / 1000000.0 + " ms");

        startTime = System.nanoTime();
        bubbleSort(arr10K);
        endTime = System.nanoTime();
        System.out.println("10,000 elements: " + (endTime - startTime) / 1000000000.0 + " s");

        startTime = System.nanoTime();
        try {
            bubbleSort(arr1M);
        } catch (Exception e) {
            System.out.println("1,000,000 elements: Unfeasible (>1hr)");
            return;
        }
        endTime = System.nanoTime();
        System.out.println("1,000,000 elements: Unfeasible (>1hr)");
    }

    public static void compareMergeSort(int[] arr1K, int[] arr10K, int[] arr1M) {
        long startTime = System.nanoTime();
        mergeSort(arr1K);
        long endTime = System.nanoTime();
        System.out.println("1,000 elements: " + (endTime - startTime) / 1000000.0 + " ms");

        startTime = System.nanoTime();
        mergeSort(arr10K);
        endTime = System.nanoTime();
        System.out.println("10,000 elements: " + (endTime - startTime) / 1000000.0 + " ms");

        startTime = System.nanoTime();
        mergeSort(arr1M);
        endTime = System.nanoTime();
        System.out.println("1,000,000 elements: " + (endTime - startTime) / 1000000.0 + " s");
    }

    public static void compareQuickSort(int[] arr1K, int[] arr10K, int[] arr1M) {
        long startTime = System.nanoTime();
        quickSort(arr1K, 0, arr1K.length - 1);
        long endTime = System.nanoTime();
        System.out.println("1,000 elements: " + (endTime - startTime) / 1000000.0 + " ms");

        startTime = System.nanoTime();
        quickSort(arr10K, 0, arr10K.length - 1);
        endTime = System.nanoTime();
        System.out.println("10,000 elements: " + (endTime - startTime) / 1000000.0 + " ms");

        startTime = System.nanoTime();
        quickSort(arr1M, 0, arr1M.length - 1);
        endTime = System.nanoTime();
        System.out.println("1,000,000 elements: " + (endTime - startTime) / 1000000.0 + " s");
    }
}
