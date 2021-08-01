package dynamicprogramming;

public class MinJumpsArray {
    public class Solution {
        public int jump(int[] A) {
            int n = A.length;
            if (n <= 1) {
                return 0;
            }
            if (A[0] == 0) {
                return -1;
            }
            int maxlength = A[0], jumps = 1, steps = A[0], i = 1;
            while (i < n) {
                if (i == n - 1) {
                    return jumps;
                }
                steps--;
                maxlength = Math.max(maxlength, i + A[i]);

                if (steps == 0) {
                    if (maxlength <= i) {
                        return -1;
                    }
                    jumps++;
                    steps = maxlength - i;
                }
                i++;
            }
            return -1;
        }
    }
}
