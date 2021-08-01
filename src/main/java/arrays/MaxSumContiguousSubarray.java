package arrays;

public class MaxSumContiguousSubarray {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int maxSubArray(final int[] A) {
            int msc = A[0], meh = A[0];
            for (int i = 1; i < A.length; i++) {
                meh = Math.max(meh + A[i], A[i]);;
                msc = Math.max(msc, meh);
            }
            return msc;
        }
    }
}
