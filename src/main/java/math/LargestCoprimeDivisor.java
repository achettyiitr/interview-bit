package math;

public class LargestCoprimeDivisor {
    public class Solution {
        public int cpFact(int A, int B) {
            int gcd = 0;
            while ((gcd = gcd(A, B)) != 1) {
                A = A / gcd;
            }
            return A;
        }

        private int gcd(int A, int B) {
            if (B == 0) return A;
            else return gcd(B, A % B);
        }
    }
}
