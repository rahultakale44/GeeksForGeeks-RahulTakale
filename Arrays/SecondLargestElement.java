import java.util.Arrays;

public class SecondLargestElement {

    public static int getSecondLargest(int[] arr) {
        int largest = -1;
        int secondLargest = -1;

        for (int num : arr) {

            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } 
            else if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }

    public static void main(String[] args) {

        int[] arr = {12, 35, 1, 10, 34, 1};

        int answer = getSecondLargest(arr);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Second largest element: " + answer);
    }
}