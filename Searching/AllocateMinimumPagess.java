import java.util.Arrays;

public class AllocateMinimumPagess {


    private static boolean canAllocate(int[] arr, int k, int maxPages) {
        int studentsCount = 1;
        int currentPagesSum = 0;

        for (int pages : arr) {
            
            if (pages > maxPages) {
                return false;
            }

            if (currentPagesSum + pages > maxPages) {
               
                studentsCount++;
                currentPagesSum = pages;

               
                if (studentsCount > k) {
                    return false;
                }
            } else {
                currentPagesSum += pages;
            }
        }
        return true;
    }

    public static int findPages(int[] arr, int k) {
      
        if (k > arr.length) {
            return -1; 
        }

        int low = Arrays.stream(arr).max().getAsInt(); 
        int high = Arrays.stream(arr).sum();         
        int result = -1;

        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(arr, k, mid)) {
                result = mid;     
                high = mid - 1;
            } else {
                low = mid + 1;    
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;

        System.out.println("Books: " + Arrays.toString(arr));
        System.out.println("Minimum maximum pages: " + findPages(arr, k));
    }
}
