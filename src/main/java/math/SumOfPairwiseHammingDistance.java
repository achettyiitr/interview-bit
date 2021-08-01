package math;

public class SumOfPairwiseHammingDistance {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int hammingDistance(final int[] A) {
            long hmd = 0, mod = 1000000007;
            int[] bc = new int[32];
            for (int i = 0; i < 32; i++) {
                int count = 0;
                for (int j = 0; j < A.length; j++) {
                    if ((A[j] & (1 << i) ) == 0) {
                        count++;
                    }
                }
                hmd = ((hmd % mod) + ((count % mod) * ((A.length - count) % mod) * 2 % mod) % mod) % mod;
            }
            return (int) hmd;
        }
    }
}
