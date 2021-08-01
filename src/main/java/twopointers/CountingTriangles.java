package twopointers;

import java.util.Arrays;

public class CountingTriangles {
    public class Solution {
        public int nTriang(int[] A) {
            Arrays.sort(A);
            int mod = (int)Math.pow(10, 9) + 7;
            int result = 0;
            for (int i = A.length - 1; i >= 2; i--) {
                int start = 0, end = i - 1;
                while (start < end) {
                    if (A[start] + A[end] > A[i]) {
                        result = (result % mod + (end - start) % mod)% mod;
                        end--;
                    } else {
                        start++;
                    }
                }
            }
            return result;
        }
    }
}
