import java.util.Arrays;

public class MergeWithoutExtraSpace {

    public static void mergeArrays(int[] a, int[] b) {
        int i = a.length - 1;
        int j = 0;

        while (i >= 0 && j < b.length) {
            if (a[i] > b[j]) {
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;

                i--;
                j++;
            } else {
                break;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 7, 10};
        int[] b = {2, 3};

        mergeArrays(a, b);

        System.out.println("a = " + Arrays.toString(a));
        System.out.println("b = " + Arrays.toString(b));
    }
}