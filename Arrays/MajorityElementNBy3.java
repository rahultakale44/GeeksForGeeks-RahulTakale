import java.util.ArrayList;
import java.util.Arrays;

public class MajorityElementNBy3 {

    public static ArrayList<Integer> findMajority(int[] arr) {
        int n = arr.length;

        int candidate1 = 0;
        int candidate2 = 1;

        int count1 = 0;
        int count2 = 0;

        
        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } 
            else if (num == candidate2) {
                count2++;
            } 
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } 
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } 
            else {
                count1--;
                count2--;
            }
        }

        
        count1 = 0;
        count2 = 0;

        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } 
            else if (num == candidate2) {
                count2++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        if (count1 > n / 3) {
            result.add(candidate1);
        }

        if (count2 > n / 3) {
            result.add(candidate2);
        }

        if (result.size() == 2 && result.get(0) > result.get(1)) {
            int temp = result.get(0);
            result.set(0, result.get(1));
            result.set(1, temp);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};

        ArrayList<Integer> answer = findMajority(arr);

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Majority elements: " + answer);
    }
}