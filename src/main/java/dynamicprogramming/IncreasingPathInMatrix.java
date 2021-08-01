package dynamicprogramming;

public class IncreasingPathInMatrix {
    public class Solution {
        public int solve(int[][] A) {
            int m = A.length;
            int n = A[0].length;
            int dp[][] = new int[m][n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1 && j == n - 1) {
                        dp[i][j] = 1;
                    } else if (i == m - 1) {
                        if (A[i][j] < A[i][j + 1] && dp[i][j + 1] != 0) {
                            dp[i][j] = 1 + dp[i][j + 1];
                        }
                    } else if (j == n - 1) {
                        if (A[i][j] < A[i + 1][j] && dp[i + 1][j] != 0) {
                            dp[i][j] = 1 + dp[i + 1][j];
                        }
                    } else {
                        if (A[i][j] < A[i][j + 1] && dp[i][j + 1] != 0) {
                            dp[i][j] = Math.max(dp[i][j], 1 + dp[i][j + 1]);
                        }
                        if (A[i][j] < A[i + 1][j] && dp[i + 1][j] != 0) {
                            dp[i][j] = Math.max(dp[i][j], 1 + dp[i + 1][j]);
                        }
                    }
                }
            }
            // for (int i[]: dp) {
            //     System.out.println(Arrays.toString(i));
            // }
            if (dp[0][0] == 0) {
                return -1;
            } else {
                return dp[0][0];
            }
        }
    }
}
