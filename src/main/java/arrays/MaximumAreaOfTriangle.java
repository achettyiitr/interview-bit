package arrays;

import java.util.Arrays;

public class MaximumAreaOfTriangle {
    public class Solution {
        public int solve(String[] A) {
            int row = A.length;
            int col = A[0].length();
            int t[][] = new int[3][col];
            int b[][] = new int[3][col];
            int l[] = new int[3];
            int r[] = new int[3];

            for (int i[]: t) Arrays.fill(i, Integer.MAX_VALUE);
            for (int i[]: b) Arrays.fill(i, Integer.MIN_VALUE);

            Arrays.fill(l, Integer.MAX_VALUE);
            Arrays.fill(r, Integer.MIN_VALUE);

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    char ch = A[i].charAt(j);
                    int index = c2I(ch);
                    t[index][j] = Math.min(t[index][j], i);
                    b[index][j] = Math.max(b[index][j], i);
                    l[index] = Math.min(l[index], j);
                    r[index] = Math.max(r[index], j);
                }
            }

            int ma = 0;
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (j == k) {
                            continue;
                        } else {
                            if (i != col - 1 && t[j][i] != Integer.MAX_VALUE && b[k][i] != Integer.MIN_VALUE && r[3 - j - k] != Integer.MIN_VALUE) {
                                double base = b[k][i] - t[j][i] + 1;
                                double height = r[3 - j - k] - i + 1;
                                double area = 0.5 * base * height;
                                ma = Math.max(ma, (int) Math.ceil(area));
                            }
                            if (i != 0 && t[j][i] != Integer.MAX_VALUE && b[k][i] != Integer.MIN_VALUE && l[3 - j - k] != Integer.MAX_VALUE) {
                                double base = b[k][i] - t[j][i] + 1;
                                double height = i - l[3 - j - k] + 1;
                                double area = 0.5 * base * height;
                                ma = Math.max(ma, (int) Math.ceil(area));
                            }
                        }
                    }
                }
            }
            return ma;
        }

        private int c2I(char ch) {
            switch(ch) {
                case 'r': return 0;
                case 'g': return 1;
                case 'b': return 2;
            }
            return -1;
        }
    }
}
