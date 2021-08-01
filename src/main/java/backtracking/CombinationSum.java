package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CombinationSum {
    public class Solution {
        public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
            Collections.sort(A);
            Map<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> unique = new ArrayList<>();

            for (int i: A) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    unique.add(i);
                    map.put(i, 1);
                }
            }

            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            solve(unique, results, new ArrayList<>(), 0, B, map);
            return results;
        }

        private void solve(ArrayList<Integer> unique, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> temp, int index, int sum, Map<Integer, Integer> map) {
            if (index == unique.size()) {
                if (sum == 0) {
                    results.add(new ArrayList<>(temp));
                }
                return;
            }

            for (int i = sum / unique.get(index); i > 0; i--) {
                int ssum = 0;
                for (int j = 0; j < i; j++) {
                    ssum += unique.get(index);
                    temp.add(unique.get(index));
                }
                solve(unique, results, temp, index + 1, sum - ssum, map);
                for (int j = 0; j < i; j++) {
                    temp.remove(temp.size() - 1);
                }
            }

            solve(unique, results, temp, index + 1, sum, map);
        }
    }
}
