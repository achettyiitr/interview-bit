package dynamicprogramming;

public class MaxSumWithoutAdjacentElements {
    public class Solution {
        public int adjacent(int[][] A) {
            int m = A.length;
            if (m == 0) {
                return 0;
            }
            int n = A[0].length;
            if (n == 0) {
                return 0;
            }
            int[] dp = new int[n];
            dp[0] = Math.max(A[0][0], A[1][0]);
            if (n == 1) {
                return dp[0];
            }
            dp[1] = Math.max(dp[0], Math.max(A[0][1], A[1][1]));
            if (n == 2) {
                return dp[1];
            }
            for (int i = 2; i < n; i++) {
                int cm = Math.max(A[0][i], A[1][i]);
                int mic = cm + dp[i - 2];
                int minc = dp[i - 1];
                dp[i] = Math.max(mic, minc);
            }
            return dp[n - 1];
        }
    }
}
