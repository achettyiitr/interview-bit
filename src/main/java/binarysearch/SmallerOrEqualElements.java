package binarysearch;

public class SmallerOrEqualElements {
    public class Solution {
        public int solve(int[] A, int B) {
            int n = A.length;
            if (B < A[0]) return 0;
            if (B > A[n - 1]) return n;
            int ceilIndex = binarySearchCeil(A, B);
            return ceilIndex + 1;
        }

        private int binarySearchCeil(int[] A, int B) {
            int n = A.length;
            int start = 0, end = n - 1, ceilIndex = -1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (A[mid] <= B) {
                    ceilIndex = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return ceilIndex;
        }
    }
}
