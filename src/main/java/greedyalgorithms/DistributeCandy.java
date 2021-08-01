package greedyalgorithms;

import java.util.Arrays;

public class DistributeCandy {
    public class Solution {
        public int candy(int[] A) {
            int n = A.length;
            int lcandies[] = new int[n];
            int rcandies[] = new int[n];
            Arrays.fill(lcandies, 1);
            Arrays.fill(rcandies, 1);
            int tcandies = 0;
            for (int i = 1; i < n; i++) {
                if (A[i] > A[i - 1]) {
                    lcandies[i] = lcandies[i - 1] + 1;
                }
            }
            for (int i = n - 2; i >= 0; i--) {
                if (A[i] > A[i + 1]) {
                    rcandies[i] = rcandies[i + 1] + 1;
                }
            }
            for (int i = 0; i < n; i++) {
                tcandies += Math.max(lcandies[i], rcandies[i]);
            }
            return tcandies;
        }
    }
}
