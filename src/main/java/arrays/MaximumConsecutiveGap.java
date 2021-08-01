package arrays;

import java.util.Arrays;

public class MaximumConsecutiveGap {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int maximumGap(final int[] A) {
            if (A.length < 2) return 0;
            int n = A.length;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i: A) {
                max = Math.max(max, i);
                min = Math.min(min, i);
            }

            int minb[] = new int[n];
            int maxb[] = new int[n];

            Arrays.fill(minb, Integer.MAX_VALUE);
            Arrays.fill(maxb, Integer.MIN_VALUE);

            double factor = ((double)(max - min)) / ((double)(n));
            for (int i: A) {
                if (i == min || i == max) {
                    continue;
                } else {
                    int bp = (int)((i - min) / factor);
                    minb[bp] = Math.min(minb[bp], i);
                    maxb[bp] = Math.max(maxb[bp], i);
                }
            }
            int maxGap = Integer.MIN_VALUE;
            int prevMax = min;
            for (int i = 0; i < minb.length; i++) {
                if (maxb[i] == Integer.MIN_VALUE && minb[i] == Integer.MAX_VALUE) {
                    continue;
                } else {
                    maxGap = Math.max(maxGap, minb[i] - prevMax);
                    prevMax = maxb[i];
                }
            }
            maxGap = Math.max(maxGap, max - prevMax);
            return maxGap;
        }
    }
}
