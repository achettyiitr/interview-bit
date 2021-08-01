package stacksandqueues;

public class RainWaterTrapped {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int trap(final int[] A) {
            int n = A.length;
            int[] lmax = new int[n];
            int[] rmax = new int[n];

            lmax[0] = A[0];
            rmax[n - 1] = A[n - 1];

            for (int i = 1; i < n; i++) {
                lmax[i] = Math.max(lmax[i - 1], A[i]);
            }

            for (int i = n - 2; i >= 0; i--) {
                rmax[i] = Math.max(rmax[i + 1], A[i]);
            }

            int wt = 0;
            for (int i = 1; i < n - 1; i++) {
                wt += Math.max(Math.min(lmax[i - 1], rmax[i + 1]) - A[i], 0);
            }
            return wt;
        }
    }
}
