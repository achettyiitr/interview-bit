package dynamicprogramming;

public class WaysToColorA3xNBoard {
    public class Solution {
        public int solve(int A) {
            long C2 = 12;
            long C3 = 24;
            long mod = 1000000007;;
            for (int i = 2; i <= A; i++) {
                long nC2 = (((5%mod * C3%mod)%mod)%mod + ((7%mod * C2%mod)%mod)%mod)%mod;
                long nC3 = (((11%mod * C3%mod)%mod)%mod + ((10%mod * C2%mod)%mod)%mod)%mod;

                C2 = nC2;
                C3 = nC3;
            }
            return (int)((C2%mod + C3%mod)%mod);
        }
    }
}
