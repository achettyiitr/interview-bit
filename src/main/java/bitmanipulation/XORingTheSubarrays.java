package bitmanipulation;

public class XORingTheSubarrays {
    public class Solution {
        public int solve(int[] A) {
            int result = 0, n = A.length;
            for (int i = 0; i < n; i++) {
                int count = (n - i) * (i + 1);
                if (count % 2 == 0) {
                    continue;
                } else {
                    result ^= A[i];
                }
            }
            return result;
        }
    }
}
