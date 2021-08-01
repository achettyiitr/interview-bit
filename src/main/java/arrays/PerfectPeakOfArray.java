package arrays;

public class PerfectPeakOfArray {
    public class Solution {
        public int perfectPeak(int[] A) {
            int n = A.length;
            int lmax[] = new int[n];
            int rmin[] = new int[n];
            lmax[0] = Integer.MIN_VALUE;
            rmin[n - 1] = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                lmax[i] = Math.max(lmax[i - 1], A[i - 1]);
            }
            for (int i = n - 2; i >= 0; i--) {
                rmin[i] = Math.min(rmin[i + 1], A[i + 1]);
            }
            for (int i = 1; i < n - 1; i++) {
                if (A[i] > lmax[i] && A[i] < rmin[i]) {
                    return 1;
                }
            }
            return 0;
        }
    }
}
