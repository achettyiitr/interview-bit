package backtracking;

import java.util.ArrayList;

public class Combinations {
    public class Solution {
        public ArrayList<ArrayList<Integer>> combine(int A, int B) {
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            solve(1, A, 0, B, results, new ArrayList<>());
            return results;
        }

        private void solve(int ci, int ti, int cs, int ts, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> temp) {
            if (ci > ti) {
                if (cs == ts) {
                    results.add(new ArrayList<>(temp));
                }
                return;
            }
            temp.add(ci);
            solve(ci + 1, ti, cs + 1, ts, results, temp);
            temp.remove(temp.size() - 1);

            solve(ci + 1, ti, cs, ts, results, temp);
        }
    }
}
