package backtracking;

import java.util.ArrayList;

public class GenerateAllParenthesesII {
    public class Solution {
        public ArrayList<String> generateParenthesis(int A) {
            ArrayList<String> results = new ArrayList<>();
            solve(A, 0, 0, "", 0, results);
            return results;
        }

        private void solve(int A, int open, int close, String asf, int index, ArrayList<String> results) {
            if (index == 2 * A) {
                if (open == close) {
                    results.add(asf);
                }
                return;
            }
            if (open < A) {
                solve(A, open + 1, close, asf + "(", index + 1, results);
            }
            if (close < open) {
                solve(A, open, close + 1, asf + ")", index + 1, results);
            }
        }
    }
}
