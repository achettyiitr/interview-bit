package hashing;

import java.util.List;

public class ValidSudoku {
    public class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int isValidSudoku(final List<String> A) {
            int n = A.size();
            int[] rows = new int[n];
            int[] cols = new int[n];
            int[][] grid = new int[n/3][n/3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    char ch = A.get(i).charAt(j);
                    if (ch == '.') {
                        continue;
                    } else {
                        int val = ch - '1';
                        if ((rows[i] & (1 << val)) != 0 || (cols[j] & (1 << val)) != 0 || (grid[i/3][j/3] & (1 << val)) != 0) {
                            return 0;
                        } else {
                            rows[i] |= (1 << val);
                            cols[j] |= (1 << val);
                            grid[i/3][j/3] |= (1 << val);
                        }
                    }
                }
            }
            return 1;
        }
    }
}
