public class LinearSearchNegative {
    public static void main(String[] args) {
        int[] array = {3, 7, 2, -5, 8, 4};
        int index = findFirstNegative(array);

        if (index != -1) {
            System.out.println("The first negative number is at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }

    public static int findFirstNegative(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
