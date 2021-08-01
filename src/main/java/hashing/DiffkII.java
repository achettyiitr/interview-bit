package hashing;

import java.util.HashSet;
import java.util.Set;

public class DiffkII {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int diffPossible(final int[] A, int B) {
            Set<Integer> set = new HashSet<>();
            int n = A.length;
            for (int i = 0; i < n; i++) {
                if (set.contains(A[i] - B) || set.contains(A[i] + B)) {
                    return 1;
                } else {
                    set.add(A[i]);
                }
            }
            return 0;
        }
    }
}
