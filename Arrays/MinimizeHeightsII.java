import java.util.Arrays;

public class MinimizeHeightsII {

    public static int getMinDiff(int[] arr, int k) {
        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        Arrays.sort(arr);

        int answer = arr[n - 1] - arr[0];

        for (int i = 1; i < n; i++) {

            if (arr[i] - k < 0) {
                continue;
            }

            int minimumHeight = Math.min(
                arr[0] + k,
                arr[i] - k
            );

            int maximumHeight = Math.max(
                arr[i - 1] + k,
                arr[n - 1] - k
            );

            answer = Math.min(
                answer,
                maximumHeight - minimumHeight
            );
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 10};
        int k = 2;

        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Value of k: " + k);

        int minimumDifference = getMinDiff(arr, k);

        System.out.println(
            "Minimum possible difference: " + minimumDifference
        );
    }
}