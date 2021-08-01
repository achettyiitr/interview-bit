package bitmanipulation;

public class CountTotalSetBits {
    public class Solution {
        private int mod = 1000000007;

        public int solve(int A) {
            if (A == 0) return 0;
            if (A == 1) return 1;
            long mP2 = maxPowerOf2(A);
            long c1 = (1 << (mP2 - 1));
            long c2 = (1 << mP2);
            long mP2Bits = (c1 % mod * mP2 % mod) % mod;
            long rOneBits = ((A + 1) % mod - c2 % mod) % mod;
            long rOtherBits = solve(A - (1 << mP2)) % mod;
            return (int)(mP2Bits + rOneBits + rOtherBits) % mod;
        }

        private int maxPowerOf2(int n) {
            int count = 0 , i = 1;
            while ((1 << i) <= n) {
                count ++;
                i++;
            }
            return i - 1;
        }
    }
}
