import java.util.ArrayList;

public class KMPPatternSearch {

    public static ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();

        int n = txt.length();
        int m = pat.length();

        int[] lps = buildLPS(pat);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            }
            else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i++;
                }
            }
        }

        return result;
    }

    private static int[] buildLPS(String pat) {
        int[] lps = new int[pat.length()];

        int length = 0;
        int i = 1;

        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            }
            else {
                if (length != 0) {
                    length = lps[length - 1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String txt = "geeksforgeeks";
        String pat = "geek";

        System.out.println("Matching indices: " + search(pat, txt));
    }
}