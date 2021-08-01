package dynamicprogramming;

public class BestTimeToBuyAndSellStocksI {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int maxProfit(final int[] A) {
            int min = Integer.MAX_VALUE, max = 0;
            for (int i: A) {
                min = Math.min(min, i);
                max = Math.max(max, i - min);
            }
            return max;
        }
    }
}
