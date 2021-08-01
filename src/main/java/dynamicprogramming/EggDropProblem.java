package dynamicprogramming;

public class EggDropProblem {
    public class Solution {
        public int solve(int A, int B) {
            int m = B;
            int n = A;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = 1 + dp[i - 1][j] + dp[i - 1][j - 1];
                    if (dp[i][j] >= B) {
                        return i;
                    }
                }
            }
            return dp[m][n];
        }
    }
}
