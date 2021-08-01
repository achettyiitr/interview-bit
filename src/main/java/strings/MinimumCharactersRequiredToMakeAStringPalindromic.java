package strings;

public class MinimumCharactersRequiredToMakeAStringPalindromic {
    public class Solution {
        public int solve(String A) {
            int ol = A.length();
            A = A + '#' + new StringBuilder(A).reverse().toString();
            // A = new StringBuilder(A).reverse().toString();
            int n = A.length();
            int lps[] = new int[n];
            lps[0] = 0;
            int i = 1;
            int len = lps[i - 1];
            while (i < n) {
                if (A.charAt(i) == A.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                } else {
                    if (len != 0) {
                        len = lps[len - 1];
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }
            // System.out.println(Arrays.toString(lps));
            return ol - lps[A.length() - 1];
        }
    }
}
