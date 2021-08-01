package dynamicprogramming;

public class TilingWithDominoes {
    public class Solution {
        public int solve(int n) {
            if (n <= 1) {
                return 0;
            }
            int A[] = new int[n + 1];
            int B[] = new int[n + 1];
            int mod = 1000000007;
            A[0] = 1;
            B[0] = 0;
            A[1] = 0;
            B[1] = 1;
            for (int i = 2; i <= n; i++) {
                A[i] = (A[i - 2]%mod + ((2%mod * B[i - 1]%mod)%mod)%mod) % mod;
                B[i] = (A[i - 1]%mod + B[i - 2]%mod) % mod;
            }
            return A[n]%mod ;
        }
    }
}
