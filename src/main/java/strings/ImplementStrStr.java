package strings;

public class ImplementStrStr {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int strStr(final String A, final String B) {
            int l1 = A.length();
            int l2 = B.length();
            if (l2 > l1) return -1;
            int d = l1 - l2;
            int i = 0, j = 0;
            while (i <= d) {
                if (compare(A, B, i)) {
                    return i;
                }
                i++;
            }
            return -1;
        }

        private boolean compare(String A, String B, int i) {
            int j = 0, k = 0;
            while (k < B.length()) {
                if (A.charAt(i + j) != B.charAt(k)) return false;
                j++;
                k++;
            }
            return true;
        }
    }
}
