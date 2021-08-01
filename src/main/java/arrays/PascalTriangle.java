package arrays;

public class PascalTriangle {
    public class Solution {
        public int[][] solve(int A) {
            int r[][] = new int[A][];
            for (int i = 0; i < A; i++) {
                r[i] = new int[i + 1];
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        r[i][j] = 1;
                    } else {
                        r[i][j] = r[i - 1][j] + r[i - 1][j - 1];
                    }
                }
            }
            return r;
        }
    }
}
