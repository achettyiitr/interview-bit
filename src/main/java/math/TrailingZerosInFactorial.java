package math;

public class TrailingZerosInFactorial {
    public class Solution {
        public int trailingZeroes(int A) {
            int r = 0, p = 5;
            while (A / p > 0) {
                r += A / p;
                p *= 5;
            }
            return r;
        }
    }
}
