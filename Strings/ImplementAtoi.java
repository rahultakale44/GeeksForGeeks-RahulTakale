public class ImplementAtoi {

    public static int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int sign = 1;
        long number = 0;

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            number = number * 10 + digit;

            if (sign == 1 && number > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && -number < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * number);
    }

    public static void main(String[] args) {
        String s = "   -123abc";

        System.out.println("String: \"" + s + "\"");
        System.out.println("Integer: " + myAtoi(s));
    }
}