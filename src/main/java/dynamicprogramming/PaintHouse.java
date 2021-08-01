package dynamicprogramming;

public class PaintHouse {
    public class Solution {
        public int solve(int[][] A) {
            int n = A.length;
            int dp[][] = new int[n][3];
            for (int i = 0; i < 3; i++) {
                dp[0][i] = A[0][i];
            }
            for (int i = 1; i < n; i++) {
                dp[i][0] = A[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = A[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = A[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                min = Math.min(min, dp[n - 1][i]);
            }
            return min;
        }
    }
}
