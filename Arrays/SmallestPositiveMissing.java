import java.util.Arrays;

public class SmallestPositiveMissing {

    public static int missingNumber(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (
                arr[i] >= 1 &&
                arr[i] <= n &&
                arr[arr[i] - 1] != arr[i]
            ) {
                int correctIndex = arr[i] - 1;

                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, -3, 4, 1, 1, 7};

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Smallest missing positive: " + missingNumber(arr));
    }
}