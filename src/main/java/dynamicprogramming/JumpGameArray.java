package dynamicprogramming;

public class JumpGameArray {
    public class Solution {
        public int canJump(int[] A) {
            int n = A.length;
            boolean[] dp = new boolean[n];
            dp[n - 1] = true;
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 1; j <= A[i] && i + j < n; j++) {
                    if (dp[i + j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[0] ? 1 : 0;
        }
    }
}
