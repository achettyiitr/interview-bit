package dynamicprogramming;

import java.util.Arrays;

public class ChainOfPairs {
    public class Solution {
        public int solve(int[][] A) {
            int n = A.length, mo = Integer.MIN_VALUE;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (A[i][0] > A[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                    mo = Math.max(mo, dp[i]);
                }
            }
            return mo;
        }
    }
}
