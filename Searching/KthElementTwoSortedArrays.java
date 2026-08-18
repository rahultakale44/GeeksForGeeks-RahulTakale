import java.util.Arrays;

public class KthElementTwoSortedArrays {

    public static int kthElement(int[] a, int[] b, int k) {
        if (a.length > b.length) {
            return kthElement(b, a, k);
        }

        int n = a.length;
        int m = b.length;

        int left = Math.max(0, k - m);
        int right = Math.min(k, n);

        while (left <= right) {
            int cut1 = left + (right - left) / 2;
            int cut2 = k - cut1;

            int leftA = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
            int leftB = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];

            int rightA = (cut1 == n) ? Integer.MAX_VALUE : a[cut1];
            int rightB = (cut2 == m) ? Integer.MAX_VALUE : b[cut2];

            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);
            }

            if (leftA > rightB) {
                right = cut1 - 1;
            } else {
                left = cut1 + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 5;

        System.out.println("Array A: " + Arrays.toString(a));
        System.out.println("Array B: " + Arrays.toString(b));
        System.out.println(k + "th element: " + kthElement(a, b, k));
    }
}