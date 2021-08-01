package arrays;

import java.util.TreeSet;

public class MaximumSumTriplet {
    public class Solution {
        public int solve(int[] A) {
            int ms = 0, n = A.length;
            int rm[] = new int[n];
            rm[n - 1] = 0;
            for (int i = n - 2; i >= 0; i--) {
                rm[i] = Math.max(rm[i + 1], A[i + 1]);
            }
            TreeSet<Integer> set = new TreeSet<>();
            set.add(A[0]);
            for (int i = 1; i < n - 1; i++) {
                Integer lower = set.lower(A[i]);
                if (lower != null && rm[i] > A[i]) {
                    ms = Math.max(ms, A[i] + lower + rm[i]);
                }
                set.add(A[i]);
            }
            return ms;
        }
    }
}
