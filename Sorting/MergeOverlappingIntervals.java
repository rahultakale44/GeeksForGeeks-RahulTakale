import java.util.*;

public class MergeOverlappingIntervals {

    public static ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int start = arr[0][0];
        int end = arr[0][1];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i][0] <= end) {
                end = Math.max(end, arr[i][1]);
            } else {
                ArrayList<Integer> interval = new ArrayList<>();
                interval.add(start);
                interval.add(end);
                result.add(interval);

                start = arr[i][0];
                end = arr[i][1];
            }
        }

        ArrayList<Integer> interval = new ArrayList<>();
        interval.add(start);
        interval.add(end);
        result.add(interval);

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1, 3},
            {2, 4},
            {6, 8},
            {9, 10}
        };

        System.out.println(mergeOverlap(arr));
    }
}