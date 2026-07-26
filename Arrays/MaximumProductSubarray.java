import java.util.Arrays;

public class MaximumProductSubarray {

    public static int maxProduct(int[] arr) {
        int maxEnding = arr[0];
        int minEnding = arr[0];
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];

            if (current < 0) {
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }

            maxEnding = Math.max(current, maxEnding * current);
            minEnding = Math.min(current, minEnding * current);

            answer = Math.max(answer, maxEnding);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Maximum product: " + maxProduct(arr));
    }
}