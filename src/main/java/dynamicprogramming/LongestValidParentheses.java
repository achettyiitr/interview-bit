package dynamicprogramming;

public class LongestValidParentheses {
    public class Solution {
        public int longestValidParentheses(String A) {
            int open = 0, close = 0, maxlength = 0;
            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                if (ch == '(') open++;
                else close++;
                if (close > open) {
                    open = 0;
                    close = 0;
                } else if (open == close) {
                    maxlength = Math.max(maxlength, 2 * open);
                }
            }

            open = 0;
            close = 0;
            for (int i = A.length() - 1; i >= 0; i--) {
                char ch = A.charAt(i);
                if (ch == '(') open++;
                else close++;
                if (open > close) {
                    open = 0;
                    close = 0;
                } else if (open == close) {
                    maxlength = Math.max(maxlength, 2 * open);
                }
            }
            return maxlength;
        }
    }
}
