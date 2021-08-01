package math;

public class IsRectangle {
    public class Solution {
        public int solve(int A, int B, int C, int D) {
            boolean canForm = (A == B && C == D) || (A == C && B == D) || (A == D && B == C);
            return canForm ? 1 : 0;
        }
    }
}
