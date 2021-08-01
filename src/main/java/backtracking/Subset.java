package backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {
    public class Solution {
        public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
            Collections.sort(A);
            ArrayList<ArrayList<Integer>> results = new ArrayList<>();
            subsetsRecursive(A, results, new ArrayList<>(), 0);
            return results;
        }

        private void subsetsRecursive(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> temp, int pos) {
            results.add(new ArrayList<>(temp));
            for (int i = pos; i < A.size(); i++) {
                temp.add(A.get(i));
                subsetsRecursive(A, results, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
