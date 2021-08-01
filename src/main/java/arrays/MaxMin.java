package arrays;

public class MaxMin {
    public class Solution {
        public int solve(int[] A) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, n = A.length;
            int i = 0;
            if (n % 2 == 0) {
                if (A[0] > A[1]) {
                    max = A[0];
                    min = A[1];
                } else {
                    max = A[1];
                    min = A[0];
                }
                i += 2;
            } else {
                max = A[0];
                min = A[0];
                i += 1;
            }

            for (; i < n; i += 2) {
                if (A[i] > A[i + 1]) {
                    if (A[i] > max) {
                        max = A[i];
                    }
                    if (A[i + 1] < min) {
                        min = A[i + 1];
                    }
                } else {
                    if (A[i + 1] > max) {
                        max = A[i + 1];
                    }
                    if (A[i] < min) {
                        min = A[i];
                    }
                }
            }
            return max + min;
        }
    }

}
