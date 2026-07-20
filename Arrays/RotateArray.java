import java.util.Arrays;

public class RotateArray {

    public static void rotateArray(int[] arr, int d) {
        int n = arr.length;

        if (n == 0) {
            return;
        }

        
        d = d % n;

        if (d == 0) {
            return;
        }

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;

        System.out.println("Before rotation: " + Arrays.toString(arr));

        rotateArray(arr, d);

        System.out.println("After rotation:  " + Arrays.toString(arr));
    }
}