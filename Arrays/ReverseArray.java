import java.util.Arrays;

public class ReverseArray {

    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 5};

        System.out.println("Before reversing: " + Arrays.toString(arr));

        reverseArray(arr);

        System.out.println("After reversing:  " + Arrays.toString(arr));
    }
}