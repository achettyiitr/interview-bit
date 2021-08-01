package math;

public class SampleQuestion {
    public class Solution {
        public int solve(int A, int B) {
            int mod = 10000000;
            return ((A % mod) + (B % mod)) % mod;
        }
    }
}
