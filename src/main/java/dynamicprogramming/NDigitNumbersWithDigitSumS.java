package dynamicprogramming;

public class NDigitNumbersWithDigitSumS {
    public class Solution {
        public int solve(int A, int B) {
            int m = A;
            int n = B;
            int mod = 1000000007;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0;
                    } else if (i == 1) {
                        dp[i][j] = (j >= 1 && j <= 9) ? 1 : 0;
                    } else {
                        for (int k = 0; k <= 9 && k <= j; k++) {
                            dp[i][j] = (dp[i][j]%mod + dp[i - 1][j - k]%mod)%mod;
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }
}
