package twopointers;

public class Array3Pointers {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int minimize(final int[] A, final int[] B, final int[] C) {
            int i1 = A.length - 1;
            int i2 = B.length - 1;
            int i3 = C.length - 1;
            int result = Integer.MAX_VALUE;
            while (i1 >= 0 && i2 >= 0 && i3 >= 0) {
                int ad1 = Math.abs(A[i1] - B[i2]);
                int ad2 = Math.abs(B[i2] - C[i3]);
                int ad3 = Math.abs(C[i3] - A[i1]);
                result = Math.min(result, Math.max(ad1, Math.max(ad2, ad3)));
                if (A[i1] >= B[i2] && A[i1] >= C[i3]) {
                    i1--;
                } else if (B[i2] >= A[i1] && B[i2] >= C[i3]) {
                    i2--;
                } else {
                    i3--;
                }
            }
            return result;
        }
    }
}
