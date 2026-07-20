import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        int pivot = -1;

        
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        
        if (pivot == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        
        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]) {
                swap(arr, i, pivot);
                break;
            }
        }

        
        reverse(arr, pivot + 1, n - 1);
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7, 5, 0};

        System.out.println("Current permutation: " + Arrays.toString(arr));

        nextPermutation(arr);

        System.out.println("Next permutation:    " + Arrays.toString(arr));
    }
}
