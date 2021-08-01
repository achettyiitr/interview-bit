package arrays;

public class MaxDistance {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int maximumGap(final int[] A) {
            int n = A.length;
            int lmin[] = new int[n];
            int rmax[] = new int[n];
            lmin[0] = 0;
            rmax[n - 1] = n - 1;
            for (int i = 1; i < n; i++) {
                if (A[lmin[i - 1]] > A[i]) {
                    lmin[i] = i;
                }  else {
                    lmin[i] = lmin[i - 1];
                }
            }
            for (int i = n - 2; i >= 0; i--) {
                if (A[rmax[i + 1]] < A[i]) {
                    rmax[i] = i;
                }  else {
                    rmax[i] = rmax[i + 1];
                }
            }
            int maxgap = 0, i = 0, j = 0;
            while (i < n && j < n) {
                if (A[lmin[i]] <= A[rmax[j]]) {
                    maxgap = Math.max(maxgap, j - i);
                    j++;
                } else {
                    i++;
                }
            }
            return maxgap;
        }
    }
}
