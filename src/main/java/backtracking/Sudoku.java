package backtracking;

import java.util.ArrayList;

public class Sudoku {
    public class Solution {
        public void solveSudoku(ArrayList<ArrayList<Character>> A) {
            int n = A.size();
            int rows[] = new int[n];
            int cols[] = new int[n];
            int grid[][] = new int[n / 3][n / 3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    char ch = A.get(i).get(j);
                    if (ch != '.') {
                        int val = ch - '1';
                        rows[i] |= (1 << val);
                        cols[j] |= (1 << val);
                        grid[i/3][j/3] |= (1 << val);
                    }
                }
            }
            solve(A, rows, cols, grid, 0);
        }

        private boolean solve(ArrayList<ArrayList<Character>> A, int[] rows, int[] cols, int[][] grid, int index) {
            if (index == A.size() * A.size()) {
                return true;
            }

            int x = index / A.size();
            int y = index % A.size();

            if (A.get(x).get(y) != '.') {
                return solve(A, rows, cols, grid, index + 1);
            }

            for (int i = 0; i < 9; i++) {
                if ((rows[x] & (1 << i)) == 0 && (cols[y] & (1 << i)) == 0 && (grid[x/3][y/3] & (1 << i)) == 0) {
                    char ch = (char)((i + 1) + '0');
                    rows[x] |= (1 << i);
                    cols[y] |= (1 << i);
                    grid[x/3][y/3] |= (1 << i);
                    A.get(x).set(y, ch);
                    if (solve(A, rows, cols, grid, index + 1)) {
                        return true;
                    }
                    rows[x] &= ~(1 << i);
                    cols[y] &= ~(1 << i);
                    grid[x/3][y/3] &= ~(1 << i);
                    A.get(x).set(y, '.');
                }
            }
            return false;
        }
    }
}
