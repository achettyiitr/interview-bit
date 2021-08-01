package dynamicprogramming;

public class BestTimeToBuyAndSellStockAtmostBTimes {
    public class Solution {
        public int solve(int[] A, int B) {
            B = Math.min(B, A.length);
            int m = B;
            int n = A.length;
            int totalprofit = 0;
            int[][] dp = new int[2][n + 1];
            for (int i = 1; i <= m; i++) {
                int ci = i % 2, pi = 1 - ci;
                int maxPreviousvalue = Integer.MIN_VALUE;
                for (int j = 1; j <= n; j++) {
                    dp[ci][j] = Math.max(dp[ci][j - 1], maxPreviousvalue + A[j - 1]);
                    maxPreviousvalue = Math.max(maxPreviousvalue, dp[pi][j] - A[j - 1]);
                }
            }
            return dp[m % 2][n];
        }
    }
}
