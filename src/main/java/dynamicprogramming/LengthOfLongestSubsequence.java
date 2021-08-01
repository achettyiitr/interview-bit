package dynamicprogramming;

import java.util.Arrays;

public class LengthOfLongestSubsequence {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int longestSubsequenceLength(final int[] A) {
            int n = A.length;

            int lis[] = new int[n];
            Arrays.fill(lis, 1);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (A[i] > A[j] && lis[j] + 1 > lis[i]) {
                        lis[i] = lis[j] + 1;
                    }
                }
            }

            int lds[] = new int[n];
            Arrays.fill(lds, 1);
            for (int i = n - 2; i >= 0; i--) {
                for (int j = n - 1; j > i; j--) {
                    if (A[i] > A[j] && lds[j] + 1 > lds[i]) {
                        lds[i] = lds[j] + 1;
                    }
                }
            }

            // System.out.println(Arrays.toString(lis));
            // System.out.println(Arrays.toString(lds));

            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, lis[i] + lds[i] - 1);
            }
            return max;
        }
    }
}
