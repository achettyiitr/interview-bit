package arrays;

public class KthRowOfPascalsTriangle {
    public class Solution {
        public int[] getRow(int n) {
            int r[] = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                if (i == 0 || i == n) {
                    r[i] = 1;
                } else {
                    r[i] = ncr(n, i);
                }
            }
            return r;
        }

        private int ncr(int n, int r) {
            int o = 1;
            for (int i = 1; i <= r; i++) {
                o *= (n - (r - i));
                o /= i;
            }
            return o;
        }
    }
}
