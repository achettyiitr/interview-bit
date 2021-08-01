package dynamicprogramming;

public class InterleavingStrings {
    public class Solution {
        public int isInterleave(String A, String B, String C) {
            int m = A.length();
            int n = B.length();
            int o = C.length();
            if (m + n != o) {
                return 0;
            }
            boolean[][] dp = new boolean[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                    } else if (i == 0) {
                        dp[i][j] = B.charAt(j - 1) == C.charAt(i + j - 1);
                    } else if (j == 0) {
                        dp[i][j] = A.charAt(i - 1) == C.charAt(i + j - 1);
                    } else {
                        char ch1 = A.charAt(i - 1);
                        char ch2 = B.charAt(j - 1);
                        char ch3 = C.charAt(i + j - 1);
                        if (ch1 == ch3 && ch2 == ch3) {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                        } else if (ch1 == ch3) {
                            dp[i][j] = dp[i - 1][j];
                        } else if (ch2 == ch3) {
                            dp[i][j] = dp[i][j - 1];
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
            return dp[m][n] ? 1 : 0;
        }
    }
}
