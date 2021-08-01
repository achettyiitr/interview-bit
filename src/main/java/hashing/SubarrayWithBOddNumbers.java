package hashing;

public class SubarrayWithBOddNumbers {
    public class Solution {
        public int solve(int[] A, int B) {
            int atmostK = solveForAtMostB(A, B);
            int atmostKMinusOne = solveForAtMostB(A, B - 1);
            return atmostK - atmostKMinusOne;
        }

        private int solveForAtMostB(int[] A, int B) {
            if (B < 0) return 0;
            int start = 0, end = 0, count = 0, result = 0, odds = 0;
            while (end < A.length) {
                if (A[end] % 2 != 0) {
                    odds++;
                }
                if (odds > B) {
                    while (odds > B) {
                        if (A[start] % 2 != 0) {
                            odds--;
                        }
                        count--;
                        start++;
                    }
                    count++;
                    result += count;
                } else {
                    count++;
                    result += count;
                }
                end++;
            }
            return result;
        }

    }
}
