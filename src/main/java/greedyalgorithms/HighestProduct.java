package greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class HighestProduct {
    public class Solution {
        public int maxp3(ArrayList<Integer> A) {
            Collections.sort(A);
            int n = A.size();
            int max1 = A.get(n - 1) * A.get(n - 2) * A.get(n - 3);
            int max2 = A.get(n - 1) * A.get(1) * A.get(0);
            return Math.max(max1, max2);
        }
    }
}
