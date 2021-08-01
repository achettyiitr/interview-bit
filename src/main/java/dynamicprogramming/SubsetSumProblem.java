package dynamicprogramming;

public class SubsetSumProblem {
    public class Solution {
        public int solve(int[] A, int B) {
            int m = A.length;
            int n = B;
            boolean[][] dp = new boolean[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                    } else if (i == 0) {
                        dp[i][j] = false;
                    } else if (j == 0) {
                        dp[i][j] = true;
                    } else {
                        if (j - A[i - 1] >= 0) {
                            dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }
            return dp[m][n] ? 1 : 0;
        }

    }
}
