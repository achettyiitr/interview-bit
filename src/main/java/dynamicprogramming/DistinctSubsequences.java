package dynamicprogramming;

public class DistinctSubsequences {
    public class Solution {
        public int numDistinct(ScrambleString A, ScrambleString B) {
            int m = B.length();
            int n = A.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if (i == 0) {
                        dp[i][j] = 1;
                    } else if (j == 0) {
                        dp[i][j] = 0;
                    } else {
                        if (B.charAt(i - 1) == A.charAt(j - 1)) {
                            dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                        } else {
                            dp[i][j] = dp[i][j - 1];
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }
}
