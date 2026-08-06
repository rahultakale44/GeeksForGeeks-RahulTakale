import java.util.Arrays;

public class FindHIndex {

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int papers = n - i;

            if (citations[i] >= papers) {
                return papers;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 5, 3, 0};

        System.out.println("Citations: " + Arrays.toString(citations));
        System.out.println("H-Index: " + hIndex(citations));
    }
}