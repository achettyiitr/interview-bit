package arrays;

public class MaximumSumSquareSubMatrix {
    public class Solution {
        public int solve(int[][] A, int B) {
            int r = A.length;
            int c = A[0].length;
            int t[][] = new int[r][c];
            for (int i = 0; i < c; i++) {
                t[0][i] = A[0][i];
            }
            for (int i = 1; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    t[i][j] = t[i - 1][j] + A[i][j];
                }
            }
            //System.out.println(Arrays.deepToString(t));
            int ms = Integer.MIN_VALUE;
            for (int i = 0; i <= r - B; i++) {
                if (i == 0) {
                    int sum = 0;
                    for (int j = 0; j < B; j++) {
                        sum += t[B - 1][j];
                    }
                    ms = Math.max(ms, sum);

                    for (int j = B; j < c; j++) {
                        sum += (t[B - 1][j] - t[B - 1][j - B]);
                        ms = Math.max(ms, sum);
                    }
                } else {
                    int sum = 0;
                    for (int j = 0; j < B; j++) {
                        sum += (t[i + B - 1][j] - t[i - 1][j]);
                    }
                    ms = Math.max(ms, sum);

                    for (int j = B; j < c; j++) {
                        sum += (t[i + B - 1][j] - t[i - 1][j]);
                        sum -= (t[i + B - 1][j - B] - t[i - 1][j - B]);
                        ms = Math.max(ms, sum);
                    }
                }
            }
            return ms;
        }
    }
}
