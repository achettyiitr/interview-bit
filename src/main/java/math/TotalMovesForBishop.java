package math;

public class TotalMovesForBishop {
    public class Solution {
        public int solve(int A, int B) {
            int count = 0;
            for (int i = A + 1, j = B + 1; i <= 8 && j <= 8; i++, j++) count++;
            for (int i = A + 1, j = B - 1; i <= 8 && j >= 1; i++, j--) count++;
            for (int i = A - 1, j = B + 1; i >= 1 && j <= 8; i--, j++) count++;
            for (int i = A - 1, j = B - 1; i >= 1 && j >= 1; i--, j--) count++;
            return count;
        }
    }
}
