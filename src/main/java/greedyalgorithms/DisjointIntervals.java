package greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DisjointIntervals {
    public class Solution {
        public int solve(ArrayList<ArrayList<Integer>> A) {
            Collections.sort(A, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                    return Integer.compare(a.get(1), b.get(1));
                }
            });
            int count = 1, i = 0, n  = A.size(), j = 1;
            while (j < n) {
                if (A.get(j).get(0) <= A.get(i).get(1)) {
                    j++;
                } else {
                    i = j;
                    j++;
                    count++;
                }
            }
            return count;
        }
    }
}
