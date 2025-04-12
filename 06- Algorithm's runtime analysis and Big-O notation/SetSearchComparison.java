import java.util.*;

public class SetSearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        int target = -1;

        for (int size : sizes) {
            System.out.println("Dataset Size: " + size);

            List<Integer> arrayList = new ArrayList<>();
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                arrayList.add(i);
                hashSet.add(i);
                treeSet.add(i);
            }

            long start, end;

            start = System.nanoTime();
            boolean foundInArray = arrayList.contains(target);
            end = System.nanoTime();
            System.out.println("Array Search: " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            boolean foundInHashSet = hashSet.contains(target);
            end = System.nanoTime();
            System.out.println("HashSet Search: " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            boolean foundInTreeSet = treeSet.contains(target);
            end = System.nanoTime();
            System.out.println("TreeSet Search: " + (end - start) / 1_000_000.0 + " ms");

            System.out.println();
        }
    }
}
