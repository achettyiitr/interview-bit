package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int lis(final int[] A) {
            int n = A.length;
            int dp[] = new int[n];
            Arrays.fill(dp, 1);
            int max = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        max = Math.max(max, dp[i]);
                    }
                }
            }
            return max;
        }
    }
}
