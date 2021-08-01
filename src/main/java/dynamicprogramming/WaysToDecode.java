package dynamicprogramming;

public class WaysToDecode {
    public class Solution {
        public int numDecodings(String A) {
            int n = A.length(), mod = (int)(Math.pow(10, 9) + 7);
            if (A.charAt(0) == '0') {
                return 0;
            }
            int dp[] = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                char ch1 = A.charAt(i - 1);
                char ch2 = A.charAt(i - 2);
                // System.out.println(ch1);
                // System.out.println(ch2);
                if (ch1 == '0') {
                    if (ch2 == '1' || ch2 == '2') {
                        dp[i] = dp[i - 2];
                    }
                } else {
                    dp[i] = dp[i - 1];
                    if (ch2 != '0') {
                        int twoDigit = Integer.parseInt(A.substring(i - 2, i));
                        if (twoDigit > 0 && twoDigit <= 26) {
                            dp[i] = (dp[i]%mod + dp[i - 2]%mod)%mod;
                        }
                    }
                }
            }
            return dp[n];
        }
    }
}
