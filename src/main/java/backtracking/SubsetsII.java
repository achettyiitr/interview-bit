package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SubsetsII {
    public class Solution {
        public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
            Collections.sort(A);
            Map<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> unique = new ArrayList<>();

            for (int i : A) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    unique.add(i);
                    map.put(i, 1);
                }
            }

            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            solve(unique, results, new ArrayList<>(), 0, map);
            return results;
        }

        private void solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> temp, int pos, Map<Integer, Integer> map) {
            results.add(new ArrayList<>(temp));
            for (int i = pos; i < A.size(); i++) {
                int val = A.get(i);
                if (map.get(val) > 0) {
                    temp.add(val);
                    map.put(val, map.get(val) - 1);
                    solve(A, results, temp, i, map);
                    temp.remove(temp.size() - 1);
                    map.put(val, map.get(val) + 1);
                }
            }
        }
    }
}
