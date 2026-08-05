import java.util.Arrays;

public class SortZerosOnesTwos {

    public static void sort012(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } 
            else if (arr[mid] == 1) {
                mid++;
            } 
            else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};

        System.out.println("Before: " + Arrays.toString(arr));

        sort012(arr);

        System.out.println("After:  " + Arrays.toString(arr));
    }
}