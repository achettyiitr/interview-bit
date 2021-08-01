package arrays;

public class MinStepsInInfiniteGrid {
    public class Solution {
        public int coverPoints(int[] A, int[] B) {
            int dist = 0;
            int n = A.length;
            for (int i = 1; i < n; i++) {
                int dx = Math.abs(A[i] - A[i - 1]);
                int dy = Math.abs(B[i] - B[i - 1]);
                int min = Math.min(dx, dy);
                int max = Math.max(dx, dy);
                dist += max;
            }
            return dist;
        }
    }
}
