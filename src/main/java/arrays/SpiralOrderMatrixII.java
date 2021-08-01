package arrays;

public class SpiralOrderMatrixII {
    public class Solution {
        public int[][] generateMatrix(int n) {
            int l = 0, r = n - 1, t = 0, b = n - 1, ptr = 0;
            int o[][] = new int[n][n];
            while (l <= r && t <= b) {
                for (int i = l; i <= r; i++) {
                    o[t][i] = ++ptr;
                }
                t++;
                for (int i = t; i <= b; i++) {
                    o[i][r] = ++ptr;
                }
                r--;
                for (int i = r; i >= l; i--) {
                    o[b][i] = ++ptr;
                }
                b--;
                for (int i = b; i >= t; i--) {
                    o[i][l] = ++ptr;
                }
                l++;
            }
            return o;
        }
    }
}
