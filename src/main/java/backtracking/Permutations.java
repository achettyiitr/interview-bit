package backtracking;

import java.util.ArrayList;
import java.util.HashSet;

public class Permutations {
    public class Solution {
        public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            solve(A, results, 0, A.size(), new ArrayList<Integer>(), new HashSet<Integer>());
            return results;
        }

        private void solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> results, int ssf, int ts,
                           ArrayList<Integer> temp, HashSet<Integer> set) {
            if (ssf == ts) {
                results.add(new ArrayList<>(temp));
                return;
            }
            for (int i = 0; i < A.size(); i++) {
                if (!set.contains(A.get(i))) {
                    set.add(A.get(i));
                    temp.add(A.get(i));
                    solve(A, results, ssf + 1, ts, temp, set);
                    temp.remove(temp.size() - 1);
                    set.remove(A.get(i));
                }
            }
        }
    }
}
