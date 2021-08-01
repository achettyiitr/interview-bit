package math;

public class MATH_BUG01 {
    public class Solution {
        public int isPrime(int A) {
            if (A == 1) return 0;
            int upperLimit = (int)(Math.sqrt(A));
            for (int i = 2; i <= upperLimit; i++) {
                if (i < A && A % i == 0) return 0;
            }
            return 1;
        }
    }
}
