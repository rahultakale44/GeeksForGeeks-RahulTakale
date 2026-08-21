import java.util.Arrays;

public class AllocateMinimumPages {

    public static int findPages(int[] arr, int k) {
        int n = arr.length;

        if (k > n) {
            return -1;
        }

        int low = 0;
        int high = 0;

        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(arr, k, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private static boolean canAllocate(int[] arr, int k, int maxPages) {
        int students = 1;
        int currentPages = 0;

        for (int pages : arr) {
            if (currentPages + pages <= maxPages) {
                currentPages += pages;
            } else {
                students++;
                currentPages = pages;

                if (students > k) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;

        System.out.println("Books: " + Arrays.toString(arr));
        System.out.println("Minimum maximum pages: " + findPages(arr, k));
    }
}