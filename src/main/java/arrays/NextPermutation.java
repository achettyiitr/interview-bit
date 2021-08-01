package arrays;

import java.util.Arrays;

public class NextPermutation {
    public class Solution {
        public int[] nextPermutation(int[] A) {
            int n = A.length;
            int i = n - 2;
            while (i >= 0) {
                if (A[i] < A[i + 1]) {
                    break;
                } else {
                    i--;
                }
            }
            if (i == -1) {
                Arrays.sort(A);
                return A;
            }
            int j = n - 1;
            while (A[j] < A[i] && j > i) j--;

            swap(A, i, j);

            j = n - 1;
            i = i + 1;
            while (i < j) {
                swap(A, i++, j--);
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
