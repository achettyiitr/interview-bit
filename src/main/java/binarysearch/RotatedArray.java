package binarysearch;

import java.util.List;

public class RotatedArray {
    public class Solution {
        // DO NOT MODIFY THE LIST
        public int findMin(final List<Integer> A) {
            int pivot = findPivot(A);
            if (pivot == -1) {
                return A.get(0);
            } else {
                return A.get(pivot);
            }
        }

        private int findPivot(final List<Integer> A) {
            int start = 0, end = A.size() - 1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (start == end) {
                    return mid;
                }
                if ((mid == start || A.get(mid) > A.get(mid - 1)) && (mid == end || A.get(mid) > A.get(mid + 1))) {
                    return mid + 1;
                } else if ((mid == start || A.get(mid) < A.get(mid - 1)) && (mid == end || A.get(mid) < A.get(mid + 1))) {
                    return mid ;
                } else if (A.get(mid) > A.get(end)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return -1;
        }
    }
}
