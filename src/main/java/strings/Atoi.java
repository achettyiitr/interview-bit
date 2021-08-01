package strings;

public class Atoi {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int atoi(final String A) {
            int i = 0, sign = 1, r = 0;
            while (i < A.length() && A.charAt(i) == ' ') i++;
            if (i < A.length()) {
                char ch = A.charAt(i);
                if (ch == '+' || ch == '-') i++;
                sign = (ch == '-') ? -1 : 1;
            }
            while (i < A.length()) {
                char ch = A.charAt(i);
                if (!Character.isDigit(ch)) break;
                int val = Character.getNumericValue(ch);
                if ((r > (Integer.MAX_VALUE / 10)) || ((r == Integer.MAX_VALUE / 10) && val > 7)) {
                    if (sign == 1) return Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                } else {
                    r = r * 10 + val;
                }
                i++;
            }
            return sign * r;
        }
    }
}
