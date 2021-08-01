package dynamicprogramming;

public class KthManhattanDistanceNeighbourhood {
    public class Solution {
        public int[][] solve(int A, int[][] B) {
            int m = B.length;
            int n = B[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < A; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int max = B[j][k];
                        if (j > 0) {
                            max = Math.max(max, B[j - 1][k]);
                        }
                        if (j < m - 1) {
                            max = Math.max(max, B[j + 1][k]);
                        }
                        if (k > 0) {
                            max = Math.max(max, B[j][k - 1]);
                        }
                        if (k < n - 1) {
                            max = Math.max(max, B[j][k + 1]);
                        }
                        dp[j][k] = max;
                    }
                }
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        B[j][k] = dp[j][k];
                    }
                }
            }
            return B;
        }
    }
}
