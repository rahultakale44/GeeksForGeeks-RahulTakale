import java.util.Arrays;

public class MaximumCircularSubarraySum {

    public static int maxCircularSum(int[] arr) {
        int totalSum = arr[0];

        int currentMax = arr[0];
        int maxSum = arr[0];

        int currentMin = arr[0];
        int minSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            totalSum += arr[i];

            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minSum = Math.min(minSum, currentMin);
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Maximum circular sum: " + maxCircularSum(arr));
    }
}