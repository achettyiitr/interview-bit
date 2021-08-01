package dynamicprogramming;

public class BestTimeToBuyAndSellStocksIII {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int maxProfit(final int[] A) {
            int n = A.length;
            if (n == 0) {
                return 0;
            }
            int[] dpmpisut = new int[n];
            int minsupt = A[0];
            for (int i = 1; i < n; i++) {
                minsupt = Math.min(minsupt, A[i]);
                if (dpmpisut[i - 1] < (A[i] - minsupt)) {
                    dpmpisut[i] = A[i] - minsupt;
                } else {
                    dpmpisut[i] = dpmpisut[i - 1];
                }
            }

            int[] dpmpibut = new int[n];
            int maxsupt = A[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                maxsupt = Math.max(maxsupt, A[i]);
                if (dpmpibut[i + 1] < (maxsupt - A[i])) {
                    dpmpibut[i] = maxsupt - A[i];
                } else {
                    dpmpibut[i] = dpmpibut[i + 1];
                }
            }
            long maxProfit = 0;
            for (int i = 0; i < n; i++) {
                maxProfit = Math.max(maxProfit, dpmpisut[i] + dpmpibut[i]);
            }
            return (int)maxProfit;
        }
    }
}
