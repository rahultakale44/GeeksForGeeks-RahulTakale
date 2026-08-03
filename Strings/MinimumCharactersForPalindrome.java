public class MinimumCharactersForPalindrome {

    public static int minChar(String s) {
        String reversed = new StringBuilder(s).reverse().toString();

        String combined = s + "$" + reversed;

        int[] lps = new int[combined.length()];

        int length = 0;
        int i = 1;

        while (i < combined.length()) {
            if (combined.charAt(i) == combined.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return s.length() - lps[combined.length() - 1];
    }

    public static void main(String[] args) {
        String s = "abc";

        System.out.println("String: " + s);
        System.out.println("Minimum characters required: " + minChar(s));
    }
}
