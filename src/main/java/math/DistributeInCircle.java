package math;

public class DistributeInCircle {
    public class Solution {
        public int solve(int A, int B, int C) {
            A = A % B;
            A -= 1;
            return (C + A) % B;
        }
    }
}
