package dynamicprogramming;

public class ZeroOneKnapsack {
    public class Solution {
        public int solve(int[] A, int[] B, int C) {
            int m = A.length;
            int n = C;
            int dp[][] = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j - B[i - 1] >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - B[i - 1]] + A[i - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[m][n];
        }
    }
}
