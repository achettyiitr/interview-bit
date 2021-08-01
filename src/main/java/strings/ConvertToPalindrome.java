package strings;

public class ConvertToPalindrome {
    public class Solution {
        public int solve(String A) {
            int start = 0, end = A.length() - 1;
            while (start <= end) {
                if (A.charAt(start) == A.charAt(end)) {
                    start++;
                    end--;
                } else {
                    break;
                }
            }
            if (start > end) {
                if (A.length() % 2 == 0) return 0;
                else return 1;
            }
            if (isPalindrome(A, start + 1, end)) return 1;
            if (isPalindrome(A, start, end - 1)) return 1;
            return 0;
        }

        private boolean isPalindrome(String A, int i, int j) {
            while (i <= j) {
                if (A.charAt(i) == A.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            return i > j ? true : false;
        }
    }
}
