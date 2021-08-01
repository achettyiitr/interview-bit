package binarysearch;

public class CountElementOccurence {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int findCount(final int[] A, int B) {
            int startIndex = startIndex(A, B);
            int endIndex = endIndex(A, B);
            if (startIndex != -1 && endIndex != -1) {
                return endIndex - startIndex + 1;
            } else {
                return 0;
            }
        }

        private int endIndex(int[] A, int B) {
            int start = 0, end = A.length -1, index = -1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (A[mid] == B) {
                    start = mid + 1;
                    index = mid;
                } else if (A[mid] > B) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return index;
        }

        private int startIndex(int[] A, int B) {
            int start = 0, end = A.length -1, index = -1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (A[mid] == B) {
                    end = mid - 1;
                    index = mid;
                } else if (A[mid] > B) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return index;
        }
    }
}
