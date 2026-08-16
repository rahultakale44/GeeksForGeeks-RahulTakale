import java.util.Arrays;

public class SearchRotatedSortedArray {

    public static int search(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {

                if (arr[left] <= key && key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {

                if (arr[mid] < key && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Key: " + key);
        System.out.println("Index: " + search(arr, key));
    }
}