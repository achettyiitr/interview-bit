package arrays;

import java.util.Arrays;

public class NobleInteger {
    public class Solution {
        public int solve(int[] A) {
            Arrays.sort(A);
            int n = A.length;
            for (int i = 0; i < n; i++) {
                if (A[i] == n - 1 - i) {
                    if (i < n - 1 && A[i] == A[i + 1]) continue;
                    return 1;
                }
            }

            return -1;
        }
    }
}
