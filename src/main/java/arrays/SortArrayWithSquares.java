package arrays;

public class SortArrayWithSquares {
    public class Solution {
        public int[] solve(int[] A) {
            int result[] = new int[A.length];
            int i = 0;
            int j = A.length - 1;
            int k = A.length - 1;
            while (i <= j) {
                if (A[i] * A[i] < A[j] * A[j]) {
                    result[k--] = A[j] * A[j];
                    j--;
                } else {
                    result[k--] = A[i] * A[i];
                    i++;
                }
            }
            return result;
        }
    }
}
