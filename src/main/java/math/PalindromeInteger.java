package math;

public class PalindromeInteger {
    public class Solution {
        public int isPalindrome(int A) {
            String s = "" + A;
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) return 0;
                i++;j--;
            }
            return 1;
        }
    }
}
