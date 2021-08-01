package strings;

public class PalindromeString {
    public class Solution {
        public int isPalindrome(String A) {
            A = A.replace(" ", "").toLowerCase();
            int n = A.length();
            int start = 0, end = n - 1;
            while (start <= end) {
                char ch1 = A.charAt(start);
                char ch2 = A.charAt(end);
                if (!Character.isLetterOrDigit(ch1)) {
                    start++;
                    continue;
                }
                if (!Character.isLetterOrDigit(ch2)) {
                    end--;
                    continue;
                }
                if (ch1 != ch2) return 0;
                else {
                    start++;
                    end--;
                }
            }
            return 1;
        }
    }
}
