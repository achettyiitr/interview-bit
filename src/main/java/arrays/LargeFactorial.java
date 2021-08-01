package arrays;

import java.math.BigInteger;

public class LargeFactorial {
    public class Solution {
        public String solve(int A) {
            BigInteger bi = BigInteger.ONE;
            for (int i = 1; i <= A; i++) {
                bi = bi.multiply(BigInteger.valueOf(i));
            }
            return bi.toString();
        }
    }
}