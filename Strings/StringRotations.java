public class StringRotations {

    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String combined = s1 + s1;

        return combined.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";

        System.out.println("First string: " + s1);
        System.out.println("Second string: " + s2);
        System.out.println("Are rotations: " + areRotations(s1, s2));
    }
}