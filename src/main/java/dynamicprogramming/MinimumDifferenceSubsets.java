package dynamicprogramming;

public class MinimumDifferenceSubsets {
    public class Solution {
        public int solve(int[] A) {
            int sum = 0;
            for (int i: A) sum += i;
            int m = A.length;
            int n = sum;
            boolean[][] dp = new boolean[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                    } else if (i == 0) {
                        dp[i][j] = false;
                    } else if (i == 0) {
                        dp[i][j] = true;
                    } else {
                        if (j >= A[i - 1]) {
                            dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }
            // for (boolean[] b: dp) {
            //     System.out.println(Arrays.toString(b));
            // }
            int minsum = Integer.MAX_VALUE;
            for (int i = 0; i <= sum/2; i++) {
                if (dp[m][i]) {
                    minsum = Math.min(minsum, sum - 2 * i);
                }
            }
            return minsum;
        }
    }
}
