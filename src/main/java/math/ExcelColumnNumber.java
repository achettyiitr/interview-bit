package math;

public class ExcelColumnNumber {
    public class Solution {
        public int titleToNumber(String A) {
            long result = 0;
            for (int i = A.length() - 1; i >= 0; i--) {
                result += c2v(A.charAt(i)) * (Math.pow(26, (A.length() - 1 - i)));
            }
            return (int)result;
        }

        private int c2v(char ch) {
            return ch - 'A' + 1;
        }
    }
}
