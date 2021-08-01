package dynamicprogramming;

public class MaximumSizeSquareSubMatrix {
    public class Solution {
        public int solve(int[][] A) {
            int m = A.length;
            int n = A[0].length;
            int[][] dp = new int[m][n];
            int max = 0;
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1 || j == n - 1) {
                        dp[i][j] = A[i][j];
                    } else {
                        if (A[i][j] == 0) {
                            dp[i][j] = 0;
                        } else {
                            dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1])) + 1;
                        }
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
            return max * max;
        }
    }
}
