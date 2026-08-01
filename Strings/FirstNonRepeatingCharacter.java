public class FirstNonRepeatingCharacter {

    public static char nonRepeatingChar(String s) {
        int[] frequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }

        return '$';
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";

        System.out.println("First non-repeating character: " + nonRepeatingChar(s));
    }
}
