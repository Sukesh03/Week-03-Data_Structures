public class RotationPoint {
    public static void main(String[] args) {
        int[] arr = {6, 7, 9, 15, 19, 2, 3};
        int rotationPoint = findRotationPoint(arr);
        System.out.println("The rotation point is at index: " + rotationPoint);
    }

    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
