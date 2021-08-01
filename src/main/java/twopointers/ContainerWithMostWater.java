package twopointers;

public class ContainerWithMostWater {
    public class Solution {
        public int maxArea(int[] A) {
            int start = 0, end = A.length - 1, lmax = start, rmax = end, ma = 0;
            while (start < end) {
                if (A[start] > A[end]) {
                    if (A[end] > A[rmax]) {
                        rmax = end;
                    }
                    ma = Math.max(ma, A[rmax] * (rmax - start));
                    end--;
                } else {
                    if (A[start] > A[lmax]) {
                        lmax = start;
                    }
                    ma = Math.max(ma, A[lmax] * (end - lmax));
                    start++;
                }
            }
            return ma;
        }
    }
}
