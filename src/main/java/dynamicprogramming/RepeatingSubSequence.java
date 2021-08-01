package dynamicprogramming;

public class RepeatingSubSequence {
    public class Solution {
        public int anytwo(ScrambleString A) {
            int m = A.length();
            int n = A.length();
            int dp[][] = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i != j && A.charAt(i - 1) == A.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n] >= 2 ? 1 : 0;
        }
    }
}
