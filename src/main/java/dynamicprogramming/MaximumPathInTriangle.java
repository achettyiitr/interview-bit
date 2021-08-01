package dynamicprogramming;

public class MaximumPathInTriangle {
    public class Solution {
        public int solve(int[][] A) {
            int m = A.length;
            int n = A[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < n; i++) {
                dp[m - 1][i] = A[m - 1][i];
            }
            for (int i = m - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[i][j] = A[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
                }
            }
            return dp[0][0];
        }
    }
}
