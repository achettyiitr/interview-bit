package dynamicprogramming;

public class CoinsInALine {
    public class Solution {
        public int maxcoin(int[] A) {
            int n = A.length;
            int[][] dp = new int[n][n];
            for (int gap = 0; gap < n; gap++) {
                for (int i = 0, j = gap; j < n; i++, j++) {
                    if (gap == 0) {
                        dp[i][j] = A[i];
                    } else if (gap == 1) {
                        dp[i][j] = Math.max(A[i], A[j]);
                    } else {
                        int selection1 = A[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                        int selection2 = A[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                        dp[i][j] = Math.max(selection1, selection2);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
