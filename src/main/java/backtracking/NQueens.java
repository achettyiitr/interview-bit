package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    public class Solution {
        public ArrayList<ArrayList<String>> solveNQueens(int n) {
            ArrayList<ArrayList<String>> results = new ArrayList<>();
            solve(n, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], 0, new ArrayList<String>(), results);
            return results;
        }

        private void solve(int n, boolean cols[], boolean ndiags[], boolean rdiags[], int row,
                           ArrayList<String> temp, ArrayList<ArrayList<String>> results) {
            if (row == n) {
                results.add(new ArrayList<>(temp));
                return;
            }
            char[] pos = new char[n];
            Arrays.fill(pos, '.');
            for (int i = 0; i < n; i++) {
                if (!cols[i] && !ndiags[row + i] && !rdiags[row - i + n - 1]) {
                    cols[i] = true;
                    ndiags[row + i] = true;
                    rdiags[row - i + n - 1] = true;
                    pos[i] = 'Q';
                    temp.add(new String(pos));
                    solve(n, cols, ndiags, rdiags, row + 1, temp, results);
                    cols[i] = false;
                    ndiags[row + i] = false;
                    rdiags[row - i + n - 1] = false;
                    pos[i] = '.';
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
