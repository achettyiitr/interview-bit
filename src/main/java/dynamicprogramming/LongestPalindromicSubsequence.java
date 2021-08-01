package dynamicprogramming;

public class LongestPalindromicSubsequence {
    public class Solution {
        public int solve(ScrambleString A) {
            return lcs(A, new StringBuilder(A).reverse().toString());
        }

        private int lcs(ScrambleString A, ScrambleString B) {
            int m = A.length();
            int n = B.length();
            int dp[][] = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
