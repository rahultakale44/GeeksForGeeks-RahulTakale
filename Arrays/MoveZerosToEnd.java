import java.util.Arrays;

public class MoveZerosToEnd {

    public static void pushZerosToEnd(int[] arr) {
        int index = 0;

        for (int num : arr) {
            if (num != 0) {
                arr[index] = num;
                index++;
            }
        }

        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 0, 2, 0, 3, 4};

        System.out.println("Before: " + Arrays.toString(arr));

        pushZerosToEnd(arr);

        System.out.println("After:  " + Arrays.toString(arr));
    }
}