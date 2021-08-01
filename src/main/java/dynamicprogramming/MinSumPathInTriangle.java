package dynamicprogramming;

import java.util.ArrayList;

public class MinSumPathInTriangle {
    public class Solution {
        public int minimumTotal(ArrayList<ArrayList<Integer>> A) {
            int m = A.size();
            int n = A.get(m - 1).size();
            int[][] dp = new int[2][n];
            for (int i = 0; i < n; i++) {
                dp[(m - 1) % 2][i] = A.get(m - 1).get(i);
            }
            for (int i = m - 2; i >= 0; i--) {
                int ci = i % 2;
                int pi = 1 - ci;
                for (int j = 0; j <= i; j++) {
                    dp[ci][j] = A.get(i).get(j) + Math.min(dp[pi][j], dp[pi][j + 1]);
                }
            }

            return dp[0][0];
        }
    }
}
