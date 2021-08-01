package dynamicprogramming;

public class EvaluateExpressionToTrue {
    public class Solution {
        public int cnttrue(String A) {
            int n = A.length();
            int mod = 1003;
            int[][][] dp = new int[n][n][2];
            for (int gap = 0; gap < n; gap+=2) {
                for (int i = 0, j = gap; j < n; i+=2, j+=2) {
                    if (gap == 0) {
                        dp[i][j][0] = (A.charAt(i) == 'F') ? 1 : 0;
                        dp[i][j][1] = (A.charAt(i) == 'T') ? 1 : 0;
                    } else {
                        for (int k = i + 1; k < j; k+=2) {
                            char op = A.charAt(k);
                            switch(op) {
                                case '|': {
                                    dp[i][j][0] = (dp[i][j][0]%mod + dp[i][k - 1][0] * dp[k + 1][j][0]%mod)%mod;
                                    dp[i][j][1] = (dp[i][j][1]%mod + dp[i][k - 1][1] * dp[k + 1][j][0]%mod)%mod;
                                    dp[i][j][1] = (dp[i][j][1]%mod + dp[i][k - 1][0] * dp[k + 1][j][1]%mod)%mod;
                                    dp[i][j][1] = (dp[i][j][1]%mod + dp[i][k - 1][1] * dp[k + 1][j][1]%mod)%mod;
                                    break;
                                }
                                case '&': {
                                    dp[i][j][0] = (dp[i][j][0]%mod + dp[i][k - 1][0] * dp[k + 1][j][0]%mod)%mod;
                                    dp[i][j][0] = (dp[i][j][0]%mod + dp[i][k - 1][1] * dp[k + 1][j][0]%mod)%mod;
                                    dp[i][j][0] = (dp[i][j][0]%mod + dp[i][k - 1][0] * dp[k + 1][j][1]%mod)%mod;
                                    dp[i][j][1] = (dp[i][j][1]%mod + dp[i][k - 1][1] * dp[k + 1][j][1]%mod)%mod;
                                    break;
                                }
                                case '^': {
                                    dp[i][j][0] = (dp[i][j][0]%mod + dp[i][k - 1][0] * dp[k + 1][j][0]%mod)%mod;
                                    dp[i][j][1] = (dp[i][j][1]%mod + dp[i][k - 1][1] * dp[k + 1][j][0]%mod)%mod;
                                    dp[i][j][1] = (dp[i][j][1]%mod + dp[i][k - 1][0] * dp[k + 1][j][1]%mod)%mod;
                                    dp[i][j][0] = (dp[i][j][0]%mod + dp[i][k - 1][1] * dp[k + 1][j][1]%mod)%mod;
                                }
                            }
                        }
                    }
                }
            }
            // for (int[][] i: dp) {
            //     for (int[] j: i) {
            //         System.out.print(Arrays.toString(j));
            //         System.out.print(".  ");
            //     }
            //     System.out.println("");
            // }
            return dp[0][n - 1][1];
        }
    }
}
