package dynamicprogramming;

public class CoinSumInfinite {
    public class Solution {
        public int coinchange2(int[] A, int B) {
            int n = A.length;
            int dp[] = new int[B + 1];
            dp[0] = 1;
            for (int i = 0; i < A.length; i++) {
                for (int k = A[i]; k <= B; k++) {
                    dp[k] = (dp[k]%1000007 +dp[k - A[i]]%1000007)%1000007;
                }
            }
            // System.out.println(Arrays.toString(dp));
            return dp[B];
        }
    }
}
