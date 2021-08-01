package arrays;

public class PickFromBothSides {
    public class Solution {
        public int solve(int[] A, int B) {
            int max = Integer.MIN_VALUE, sum = 0;
            for (int i = 0; i < B; i++) {
                sum += A[i];
            }
            max = Math.max(max, sum);
            int j = B - 1;
            for (int i = A.length - 1; i >= 0 && j >= 0; i--) {
                sum += A[i];
                sum -= A[j];
                j--;
                max = Math.max(max, sum);
            }
            return max;
        }
    }
}
