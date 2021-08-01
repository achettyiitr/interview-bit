package dynamicprogramming;

public class UniquePathsInAGrid {
    public class Solution {
        public int uniquePathsWithObstacles(int[][] A) {
            int m = A.length;
            int n = A[0].length;
            int[][] dp = new int[m][n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (A[i][j] == 1) {
                        dp[i][j] = 0;
                        continue;
                    }
                    if (i == m - 1 && j == n - 1) {
                        dp[i][j] = 1;
                    } else if (i == m - 1) {
                        dp[i][j] = dp[i][j + 1];
                    } else if (j == n - 1) {
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                    }
                }
            }
            return dp[0][0];
        }
    }
}
