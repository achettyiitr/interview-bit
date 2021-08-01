package arrays;

import java.util.Arrays;

public class WaveArray {
    public class Solution {
        public int[] wave(int[] A) {
            Arrays.sort(A);
            int n = A.length;
            for (int i = 1; i < n; i += 2) {
                swap(A, i, i - 1);
            }
            return A;
        }

        private void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
