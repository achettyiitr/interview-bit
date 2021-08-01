package dynamicprogramming;

public class PalindromePartitioningII {
    public class Solution {
        public int minCut(String A) {
            int n = A.length();
            boolean[][] dp = new boolean[n][n];
            for (int gap = 0; gap < n; gap++) {
                for (int i = 0, j = gap; j < n; i++, j++) {
                    if (gap == 0) {
                        dp[i][j] = true;
                    } else if (gap == 1) {
                        if (A.charAt(i) == A.charAt(j)) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = false;
                        }
                    } else {
                        if (A.charAt(i) == A.charAt(j)) {
                            dp[i][j] = dp[i + 1][j - 1];
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
            int[][] ep = new int[n][n];
            for (int gap = 0; gap < n; gap++) {
                for (int i = 0, j = gap; j < n; i++, j++) {
                    if (gap == 0) {
                        ep[i][j] = 0;
                    } else if (gap == 1) {
                        if (A.charAt(i) == A.charAt(j)) {
                            ep[i][j] = 0;
                        } else {
                            ep[i][j] = 1;
                        }
                    } else {
                        if (dp[i][j]) {
                            ep[i][j] = 0;
                        } else {
                            int min = Integer.MAX_VALUE;
                            for (int k = i; k < j; k++) {
                                int left = ep[i][k];
                                int right = ep[k + 1][j];
                                min = Math.min(min, left + right + 1);
                            }
                            ep[i][j] = min;
                        }
                    }
                }
            }
            return ep[0][n - 1];
        }
    }
}
