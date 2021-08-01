package dynamicprogramming;

public class BestTimeToBuyAndSellStocksII {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int maxProfit(final int[] A) {
            if (A.length == 0) {
                return 0;
            }
            int bd = 0, sd = 0, profit = 0;
            for (int i = 1; i < A.length; i++) {
                if (A[i] > A[i - 1]) {
                    sd++;
                } else {
                    profit += A[sd] - A[bd];
                    bd = sd = i;
                }
            }
            profit += A[sd] - A[bd];
            return profit;
        }
    }
}
