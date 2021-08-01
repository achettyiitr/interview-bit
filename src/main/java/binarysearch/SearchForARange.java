package binarysearch;

public class SearchForARange {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int[] searchRange(final int[] A, int B) {
            return new int[] {firstOccurance(A, B), lastOccurance(A, B)};
        }

        private int firstOccurance(int[] A, int B) {
            int start = 0, end = A.length - 1, ans = -1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (A[mid] == B) {
                    ans = mid;
                    end = mid - 1;
                } else if (A[mid] > B) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return ans;
        }

        private int lastOccurance(int[] A, int B) {
            int start = 0, end = A.length - 1, ans = -1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (A[mid] == B) {
                    ans = mid;
                    start = mid + 1;
                } else if (A[mid] > B) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return ans;
        }
    }
}
