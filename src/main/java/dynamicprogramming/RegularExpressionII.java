package dynamicprogramming;

public class RegularExpressionII {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int isMatch(final String A, final String B) {
            int m = B.length();
            int n = A.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                    } else if (i == 0) {
                        dp[i][j] = false;
                    } else if (j == 0) {
                        char bh = B.charAt(i - 1);
                        if (i >= 2 && bh == '*') {
                            dp[i][j] = dp[i - 2][j];
                        } else {
                            dp[i][j] = false;
                        }
                    } else {
                        char ah = A.charAt(j - 1);
                        char bh = B.charAt(i - 1);
                        if (bh == '*') {
                            if (i >= 2) {
                                char ph = B.charAt(i - 2);
                                if (dp[i - 2][j]) {
                                    dp[i][j] = true;
                                } else if ((ph == '.' || ph == ah ) && dp[i][j - 1]){
                                    dp[i][j] = true;
                                } else {
                                    dp[i][j] = false;
                                }
                            } else {
                                dp[i][j] = false;
                            }
                        } else if (bh == '.') {
                            dp[i][j] = dp[i - 1][j - 1];
                        } else if (bh == ah) {
                            dp[i][j] = dp[i - 1][j - 1];
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
