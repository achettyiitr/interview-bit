package bitmanipulation;

import java.util.Arrays;

public class MinXORValue {
    public class Solution {
        public int findMinXor(int[] A) {
            Arrays.sort(A);
            int minxor = Integer.MAX_VALUE;
            for (int i = 0; i < A.length - 1; i++) {
                minxor = Math.min(minxor, A[i] ^ A[i + 1]);
            }
            return minxor;
        }
    }
}
